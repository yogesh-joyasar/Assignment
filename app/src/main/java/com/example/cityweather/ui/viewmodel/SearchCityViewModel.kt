package com.example.cityweather.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cityweather.data.repository.HistoryRepository
import com.example.cityweather.ui.models.SearchResponse
import com.example.cityweather.data.repository.SearchCityRepository
import com.example.cityweather.ui.models.AreaName
import javax.inject.Inject


class SearchCityViewModel @Inject constructor( private val repository: SearchCityRepository ) : ViewModel() {

    private val cities : LiveData<SearchResponse>

    init {
        cities = repository.getAllCities()
    }

    fun searchCity(searchString : String, apiKey : String, format: String, context : Context) {
        repository.searchCity( apiKey,searchString, format, context)
    }

    fun getSearchCityLiveData(): LiveData<SearchResponse>{
        return repository.getAllCities()
    }


}