package com.homework.mhafidhaziz.weatherapp.di.module

import com.homework.mhafidhaziz.weatherapp.network.WeatherApi
import com.homework.mhafidhaziz.weatherapp.network.WeatherData
import com.homework.mhafidhaziz.weatherapp.network.WeatherFactory
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
class DataModule {

    @Provides
    @Singleton
    internal fun provideWeatherData(weatherApi: WeatherApi): WeatherData {
        return WeatherData(weatherApi)
    }

    @Provides
    @Singleton
    internal fun provideWeatherFactory(): WeatherFactory {
        return WeatherFactory()
    }
}