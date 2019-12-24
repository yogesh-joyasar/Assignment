package com.example.cityweather.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AreaName(
    @SerializedName("value")
    @Expose
    private var value: String
) {

    override fun toString(): String = value
}