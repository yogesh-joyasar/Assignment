package com.example.cityweather.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cityweather.data.repository.CityWeatherRepository
import com.example.cityweather.ui.models.SearchResponse


/**
 * Created by Sanket Mendon on 2019-12-26,
 * Capgemini India Ltd
 * sanket.mendon@capgemini.com
 */
class CityWeatherViewModel : ViewModel() {

    private val cityweather: LiveData<SearchResponse>
    private val repository: CityWeatherRepository

    init {
        repository = CityWeatherRepository()
        cityweather = repository.getCityWeather()
    }

    fun searchWeather(selectedCity: String, context: Context) {
        repository.searchCityWeather(selectedCity, context)
    }

    fun getCityLiveData(): LiveData<SearchResponse> {
        return repository.getCityWeather()
    }
}