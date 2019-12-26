package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityWeatherResponse(
    @SerializedName("data")
    @Expose
    val data : CityWeatherResponseData
) {
}