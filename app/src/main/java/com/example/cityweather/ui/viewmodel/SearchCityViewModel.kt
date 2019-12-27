package com.example.cityweather.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cityweather.data.repository.SearchCityRepository
import com.example.cityweather.ui.models.SearchResponse
import javax.inject.Inject


class SearchCityViewModel @Inject constructor( private val repository: SearchCityRepository ) : ViewModel() {

    private val cities : LiveData<SearchResponse>

    init {
        cities = repository.getAllCities()
    }

    fun searchCity(searchString : String, apiKey : String, format: String) {
        repository.searchCity( apiKey,searchString, format)
    }

    fun getSearchCityLiveData(): MutableLiveData<SearchResponse>{
        return repository.getAllCities()
    }


}