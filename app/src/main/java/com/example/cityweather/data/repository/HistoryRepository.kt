package com.example.cityweather.data.repository

import androidx.lifecycle.LiveData
import com.example.cityweather.data.db.AreaNameDao
import com.example.cityweather.ui.models.AreaName

class HistoryRepository(private val areaNameDao: AreaNameDao) {


    val allCity : LiveData<AreaName> = areaNameDao.getAreaNames()

    fun insert(areaName : AreaName){
        areaNameDao.insert(areaName)
    }

    fun getHistory(): LiveData<AreaName> {
        return allCity
    }
}