package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDesc(
    @SerializedName("value")
    @Expose
    val value : String
) {
}