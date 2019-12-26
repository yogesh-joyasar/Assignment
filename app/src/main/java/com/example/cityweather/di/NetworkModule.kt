package com.example.cityweather.di


import androidx.annotation.NonNull
import com.example.cityweather.data.network.Api
import com.example.cityweather.util.BASE_URL
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {


    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return  OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request()
                    .newBuilder()
                    .build())
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient): Retrofit {

        val gson =  GsonBuilder()
            .setLenient()
            .create()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideService(@NonNull retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}