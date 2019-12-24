package com.example.cityweather.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherUrl(
    @SerializedName("value")
    @Expose
    private var value : String
) {
}