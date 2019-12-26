package com.example.cityweather.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cityweather.data.repository.CityWeatherRepository
import com.example.cityweather.ui.models.CityWeatherResponse
import com.example.cityweather.ui.models.SearchResponse

class CityWeatherViewModel : ViewModel() {

    private val cityweather: LiveData<CityWeatherResponse>
    private val repository: CityWeatherRepository

    init {
        repository = CityWeatherRepository()
        cityweather = repository.getCityWeather()
    }

    fun searchWeather(selectedCity: String, context: Context) {
        repository.searchCityWeather(selectedCity, context)
    }

    fun getCityLiveData(): LiveData<CityWeatherResponse> {
        return repository.getCityWeather()
    }
}