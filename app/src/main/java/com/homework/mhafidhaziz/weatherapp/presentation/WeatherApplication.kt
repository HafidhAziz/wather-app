package com.homework.mhafidhaziz.weatherapp.presentation

import android.app.Application
import com.homework.mhafidhaziz.weatherapp.di.component.AppComponent
import com.homework.mhafidhaziz.weatherapp.di.component.DaggerAppComponent
import com.homework.mhafidhaziz.weatherapp.di.module.AppModule
import com.homework.mhafidhaziz.weatherapp.di.module.NetworkModule


/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */
class WeatherApplication : Application() {
    private var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()
    }

    fun getComponent(): AppComponent? {
        return component
    }
}