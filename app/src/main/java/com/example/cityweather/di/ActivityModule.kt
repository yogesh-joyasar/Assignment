package com.example.cityweather.di

import com.example.cityweather.MainActivity
import com.example.cityweather.ShowWeatherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

 @ContributesAndroidInjector
 internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeShowWeatherActivity(): ShowWeatherActivity
}