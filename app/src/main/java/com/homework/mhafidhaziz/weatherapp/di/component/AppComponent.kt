package com.homework.mhafidhaziz.weatherapp.di.component

import com.homework.mhafidhaziz.weatherapp.di.module.AppModule
import com.homework.mhafidhaziz.weatherapp.di.module.DataModule
import com.homework.mhafidhaziz.weatherapp.di.module.NetworkModule
import com.homework.mhafidhaziz.weatherapp.network.WeatherFactory
import com.homework.mhafidhaziz.weatherapp.presentation.weather.WeatherActivity
import dagger.Component
import javax.inject.Singleton


/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class])
interface AppComponent {
    fun inject(activity: WeatherActivity)
    fun inject(weatherFactory: WeatherFactory)
}