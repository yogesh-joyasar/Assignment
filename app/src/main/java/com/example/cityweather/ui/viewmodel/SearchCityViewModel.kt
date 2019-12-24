package com.example.cityweather.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cityweather.data.network.response.SearchResponse
import com.example.cityweather.data.repository.SearchCityRepository


class SearchCityViewModel : ViewModel() {

    private val cities : LiveData<SearchResponse>
    private val repository : SearchCityRepository

    init {
        repository = SearchCityRepository()
        cities = repository.getAllCities()
    }

    fun searchCity(searchString : String, apiKey : String) {
        repository.searchCity(searchString, apiKey)
    }

    fun getSearchCityLiveData(): LiveData<SearchResponse>{
        return repository.getAllCities()
    }


}