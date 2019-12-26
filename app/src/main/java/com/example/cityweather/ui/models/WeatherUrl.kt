package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherUrl(
    @SerializedName("value")
    @Expose
    private var value : String
) {
}