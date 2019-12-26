package com.example.cityweather.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cityweather.data.repository.HistoryRepository
import com.example.cityweather.ui.models.AreaName
import javax.inject.Inject

class HistoryViewModel @Inject constructor(private val repository: HistoryRepository) : ViewModel() {

    lateinit var allCityHistory : LiveData<AreaName>

    fun insert(area: AreaName) : Long{
        return repository.insert(area)
    }

    fun getHistory(context: Context): LiveData<AreaName>{
        allCityHistory = repository.getHistory()
        return allCityHistory
    }
}