package com.example.cityweather.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cityweather.data.repository.HistoryRepository
import com.example.cityweather.ui.models.AreaName
import javax.inject.Inject

class HistoryViewModel @Inject constructor(private val repository: HistoryRepository) : ViewModel() {

    lateinit var allCityHistory : List<AreaName>
    fun insert(area: AreaName) : Long{
        return repository.insert(area)
    }

    fun getHistory(): List<AreaName>{
        allCityHistory = repository.getHistory()
        Log.i("List", allCityHistory.size.toString())
        return allCityHistory
    }
}