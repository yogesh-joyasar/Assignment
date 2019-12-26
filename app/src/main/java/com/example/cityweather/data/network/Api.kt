package com.example.cityweather.data.network

import com.example.cityweather.ui.models.CityWeatherResponse
import com.example.cityweather.ui.models.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface Api {

    @GET("search.ashx")
    fun getCities(@Query("key") apiKey: String,
                  @Query("q") city: String,
                  @Query("format") format: String): Observable<SearchResponse>


    @GET("weather.ashx")
    fun getCityWeather(@Query("key") apiKey: String,
                  @Query("q") city: String,
                  @Query("format") format: String): Observable<CityWeatherResponse>
}