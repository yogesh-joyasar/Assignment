package com.example.cityweather.ui.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResponse(

    @SerializedName("search_api")
    @Expose
    val searchApi: SearchAPI
)