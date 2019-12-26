package com.example.cityweather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.cityweather.ui.viewmodel.CityWeatherViewModel
import com.example.cityweather.util.CommonVariables
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_city_weather.*
import javax.inject.Inject

class ShowWeatherActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: CityWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_weather)

        val selectedCity: String = intent.getStringExtra(CommonVariables.Constants.SELECTED_CITY)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CityWeatherViewModel::class.java)
        viewModel.searchWeather(selectedCity, applicationContext)
        viewModel.getCityLiveData().observe(this, Observer { t->

            idTvCityName.setText(t.data.request.get(0).query)
            idTvTemperature.setText("Temperature: "+t.data.current_condition.get(0).tempC)
            idTvHumidity.setText("Humidity: "+t.data.current_condition.get(0).humidity)
            idTvWeather.setText("Weather: "+t.data.current_condition.get(0).weatherDesc.get(0).value)
            val imgUrl = t.data.current_condition.get(0).weatherIconUrl.get(0).value
            Picasso.get().load(imgUrl).into(idIvIcon);

        })
    }
}