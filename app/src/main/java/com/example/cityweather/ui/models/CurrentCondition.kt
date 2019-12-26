package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentCondition(
    @SerializedName("temp_C")
    @Expose
    val tempC: String,
    @SerializedName("temp_F")
    @Expose
    val tempF: String,
    @SerializedName("weatherIconUrl")
    @Expose
    val weatherIconUrl: MutableList<WeatherIconUrl>,
    @SerializedName("weatherDesc")
    @Expose
    val weatherDesc: MutableList<WeatherDesc>,
    @SerializedName("humidity")
    @Expose
    val humidity: String

)