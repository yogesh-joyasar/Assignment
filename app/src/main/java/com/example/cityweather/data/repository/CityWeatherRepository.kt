package com.example.cityweather.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cityweather.data.network.Api
import com.example.cityweather.data.network.RestClient
import com.example.cityweather.data.network.core.ApiFail
import com.example.cityweather.data.network.core.ApiSuccess
import com.example.cityweather.data.network.core.HttpErrorResponse
import com.example.cityweather.ui.models.CityWeatherResponse
import com.example.cityweather.util.BASE_URL
import com.example.cityweather.util.apiKey
import com.example.cityweather.util.format
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class CityWeatherRepository @Inject constructor(private val api: Api) {

    val data: MutableLiveData<CityWeatherResponse> = MutableLiveData()

    fun searchCityWeather(selectedCity: String, context: Context) {

        api.getCityWeather(apiKey, selectedCity, format)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiSuccess<CityWeatherResponse>() {
                override fun call(t: CityWeatherResponse?) {
                    Log.i("Success", "Success")
                    data.value = t
                }

            }, object : ApiFail() {
                override fun httpStatus(response: HttpErrorResponse) {
                    Log.i("Error", response.error)
                }

                override fun noNetwork() {

                }

                override fun unknownError(e: Throwable) {
                    Log.i("Error", e.message)
                }

            })
    }


    fun getCityWeather(): LiveData<CityWeatherResponse> {
        return data
    }
}