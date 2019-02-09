package com.homework.mhafidhaziz.weatherapp.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */

@Module
class AppModule(application: Application) {

    private var mApplication = application

    @Provides
    @Singleton
    internal fun provideApplication(): Application {
        return mApplication
    }
}