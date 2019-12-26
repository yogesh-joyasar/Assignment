package com.example.cityweather.data.db

import android.content.Context
import androidx.room.*
import com.example.cityweather.ui.models.AreaName
import com.example.cityweather.util.CommonVariables

@Database(entities = arrayOf(AreaName::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun areaNameDao(): AreaNameDao


    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    CommonVariables.Constants.DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}