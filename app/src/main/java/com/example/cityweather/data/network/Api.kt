package com.example.cityweather.data.network

import com.example.cityweather.data.network.response.SearchResponse
import com.example.cityweather.util.BASE_URL
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import rx.Observable

interface Api {

    @GET("search.ashx")
    fun getCities(@Query("key") apiKey: String,
                  @Query("q") city: String): Observable<SearchResponse>
}