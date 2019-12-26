package com.example.cityweather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cityweather.ui.viewmodel.CityWeatherViewModel
import com.example.cityweather.util.CommonVariables
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_city_weather.*

class ShowWeatherActivity : AppCompatActivity() {
    private lateinit var viewModel: CityWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_weather)

        val selectedCity: String = intent.getStringExtra(CommonVariables.Constants.SELECTED_CITY)

        viewModel = ViewModelProviders.of(this).get(CityWeatherViewModel::class.java)
        viewModel.searchWeather(selectedCity, applicationContext)
        viewModel.getCityLiveData().observe(this, Observer { t->

            txt_city_name.setText(t.data.request.get(0).query)
            txt_temperature.setText("Temperature: "+t.data.current_condition.get(0).tempC)
            txt_humidity.setText("Humidity: "+t.data.current_condition.get(0).humidity)
            txt_weather.setText("Weather: "+t.data.current_condition.get(0).weatherDesc.get(0).value)
            val imgUrl = t.data.current_condition.get(0).weatherIconUrl.get(0).value
            Picasso.get().load(imgUrl).into(img_city_image);

        })
    }
}