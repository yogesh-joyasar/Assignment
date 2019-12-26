package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CityWeatherResponseData(
    @SerializedName("request")
    @Expose
    val request : MutableList<City>,
    @SerializedName("current_condition")
    @Expose
    val current_condition : MutableList<CurrentCondition>

) {


}