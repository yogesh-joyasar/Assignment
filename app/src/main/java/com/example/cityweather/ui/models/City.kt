package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class City(
    @SerializedName("type")
    @Expose
    var type: String,
    @SerializedName("query")
    @Expose
    var query: String

) {

}