package com.example.cityweather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cityweather.databinding.ActivityCityWeatherBinding
import com.example.cityweather.ui.viewmodel.CityWeatherViewModel
import com.example.cityweather.util.CommonVariables

class ShowWeatherActivity : AppCompatActivity() {
    private lateinit var viewModel: CityWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCityWeatherBinding = DataBindingUtil.setContentView(this, R.layout.activity_city_weather)
        val selectedCity: String = intent.getStringExtra(CommonVariables.Constants.SELECTED_CITY)
        viewModel = ViewModelProviders.of(this).get(CityWeatherViewModel::class.java)
        viewModel.searchWeather(selectedCity, applicationContext)
        viewModel.getCityLiveData().observe(this, Observer { t->
            Log.d("TAG", ""+t.searchApi.result[0].areaName)
            //binding.setVariable(searchApi)
        })
    }
}