package com.example.cityweather.ui.viewmodel

import android.content.Context
import android.hardware.Camera
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cityweather.data.db.AppDatabase
import com.example.cityweather.data.repository.HistoryRepository
import com.example.cityweather.ui.models.AreaName

class HistoryViewModel(val context: Context) : ViewModel() {

    private val repository : HistoryRepository

    lateinit var allCityHistory : LiveData<AreaName>

    init {

        val areaNameDao = AppDatabase.getDatabase(context).areaNameDao()
        repository = HistoryRepository(areaNameDao)
        allCityHistory = repository.getHistory()
    }


    fun insert(areaName: AreaName) {
        repository.insert(areaName)
    }

    fun getHistory(): LiveData<AreaName>{
        return allCityHistory
    }
}