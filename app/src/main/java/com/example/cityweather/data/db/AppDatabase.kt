package com.example.cityweather.data.db


import androidx.room.*
import com.example.cityweather.ui.models.AreaName

@Database(entities = arrayOf(AreaName::class), version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun areaNameDao(): AreaNameDao
}