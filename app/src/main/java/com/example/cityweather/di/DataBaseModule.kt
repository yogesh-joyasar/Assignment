package com.example.cityweather.di

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Room
import com.example.cityweather.data.db.AppDatabase
import com.example.cityweather.data.db.AreaNameDao
import com.example.cityweather.util.CommonVariables
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, CommonVariables.Constants.DB_NAME).allowMainThreadQueries().build()
    }


    @dagger.Provides
    @javax.inject.Singleton
    fun provideAreaNameDao(database: AppDatabase): AreaNameDao = database.areaNameDao()
    }