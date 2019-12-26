package com.example.cityweather.di


import com.example.cityweather.application.WeatherApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    DataBaseModule::class,
    ApplicationModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: WeatherApplication)

}