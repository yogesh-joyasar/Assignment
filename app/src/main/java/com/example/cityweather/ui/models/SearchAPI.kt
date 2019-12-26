package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SearchAPI {

    @SerializedName("result")
    @Expose
    var result = mutableListOf<Result>()
}