package com.example.cityweather.data.network

import com.example.cityweather.data.network.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface Api {

    @GET("search.ashx")
    fun getCities(@Query("key") apiKey: String,
                  @Query("q") city: String,
                  @Query("format") format: String): Observable<SearchResponse>
}