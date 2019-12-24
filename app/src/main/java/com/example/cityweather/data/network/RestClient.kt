package com.example.cityweather.data.network

import okhttp3.OkHttpClient
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.core.Persister
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


object RestClient {

    private fun getRetroft(url: String): Retrofit{
        return Retrofit.Builder()
            .baseUrl(url)
            .client(getClient())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict(Persister(
                AnnotationStrategy()
            )))
            .build()
    }

    private fun getClient(): OkHttpClient{

        val okHttpClient = OkHttpClient.Builder()
            .build()

        return okHttpClient
    }

    fun api(url : String): Api {
        return getRetroft("https://api.worldweatheronline.com/premium/v1/search.ashx?key=e81da1ea637b4abab6581155192312&q=mum").create<Api>(
            Api::class.java)
    }
}