package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherIconUrl(
    @SerializedName("value")
    @Expose
    val value: String
) {
}