package com.example.cityweather.data.network.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchAPI {

    @SerializedName("result")
    @Expose
    var result = mutableListOf<Result>()
}