package com.example.cityweather.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cityweather.data.network.RestClient
import com.example.cityweather.data.network.core.ApiFail
import com.example.cityweather.data.network.core.ApiSuccess
import com.example.cityweather.data.network.core.HttpErrorResponse
import com.example.cityweather.data.network.response.SearchResponse
import com.example.cityweather.ui.models.City
import com.example.cityweather.util.BASE_URL
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class SearchCityRepository {

    lateinit var cities : LiveData<SearchResponse>
    val data: MutableLiveData<SearchResponse> = MutableLiveData()

    fun searchCity(apiKey : String, searchString : String,format:String, context : Context){


        RestClient.api(BASE_URL,context).getCities( apiKey, searchString,format)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiSuccess<SearchResponse>(){
                override fun call(t: SearchResponse?) {
                    data.value = t
                }

            }, object : ApiFail(){
                override fun httpStatus(response: HttpErrorResponse) {
                    Log.i("Error",response.error)
                }

                override fun noNetwork() {

                }

                override fun unknownError(e: Throwable) {
                    Log.i("Error",e.message)
                }

            })
    }


    fun getAllCities(): LiveData<SearchResponse>{
        return data
    }
}