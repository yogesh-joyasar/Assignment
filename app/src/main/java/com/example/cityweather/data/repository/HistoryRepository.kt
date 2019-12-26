package com.example.cityweather.data.repository


import androidx.lifecycle.LiveData
import com.example.cityweather.data.db.AreaNameDao
import com.example.cityweather.data.network.Api
import com.example.cityweather.ui.models.AreaName
import javax.inject.Inject

class HistoryRepository @Inject constructor(private val api: Api, private val dao: AreaNameDao) {

    private var allCityHistory : LiveData<AreaName>? =null

    fun getHistory() : LiveData<AreaName>{
        allCityHistory = dao.getAreaNames()
        return allCityHistory!!
    }

    fun insert(areaName: AreaName) : Long{
        return dao.insert(areaName)
    }

}