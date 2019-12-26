package com.example.cityweather.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cityweather.ui.models.AreaName

@Dao
interface AreaNameDao {

    @Insert
    fun insert(areaName: AreaName)

    @Query("Select * from area_name order by id desc")
    fun getAreaNames(): LiveData<AreaName>


}