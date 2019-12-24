package com.example.cityweather.data.network

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RestClient {

    private fun getRetroft(url: String, context: Context): Retrofit{
        return Retrofit.Builder()
            .baseUrl(url)
            .client(getClient(context))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClient( context : Context): OkHttpClient{

        val chuckInterceptor = ChuckInterceptor(context)
        chuckInterceptor.showNotification(true)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(chuckInterceptor)
            .build()

        return okHttpClient
    }

    fun api(url : String, context: Context): Api {
        return getRetroft(url,context).create<Api>(
            Api::class.java)
    }
}