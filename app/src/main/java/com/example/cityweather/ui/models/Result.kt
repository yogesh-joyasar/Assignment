package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(

    @SerializedName("areaName")
    @Expose
    var areaName: MutableList<AreaName>,
    @SerializedName("country")
    @Expose
    var country: MutableList<Country>,
    @SerializedName("region")
    @Expose
    var region: MutableList<Region>,
    @SerializedName("latitude")
    @Expose
    private var latitude: String,
    @SerializedName("longitude")
    @Expose
    private var longitude: String,
    @SerializedName("population")
    @Expose
    private var population: String,
    @SerializedName("weatherUrl")
    @Expose
    private var weatherUrl: MutableList<WeatherUrl>
)