package com.example.cityweather.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(private val mApplication: Application) {
    @Provides
    internal fun provideContext(): Context { return mApplication }
    @Provides
    internal fun provideApplication(): Application { return mApplication }

}