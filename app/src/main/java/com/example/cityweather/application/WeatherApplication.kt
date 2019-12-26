package com.example.cityweather.application

import android.app.Activity
import android.app.Application
import com.example.cityweather.di.AppComponent
import com.example.cityweather.di.ApplicationModule
import com.example.cityweather.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class WeatherApplication :Application(), HasActivityInjector {

    lateinit var appComponent: AppComponent
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>



    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().applicationModule( ApplicationModule(this)) .build();
        appComponent.inject(this);
    }

    fun getComponent(): AppComponent? {
        return appComponent
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector!!

}