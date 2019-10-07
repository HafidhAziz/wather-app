package com.homework.mhafidhaziz.weatherapp.di.module

import com.homework.mhafidhaziz.weatherapp.BuildConfig
import com.homework.mhafidhaziz.weatherapp.network.WeatherApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.END_POINT)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    internal fun provideApi(): WeatherApi {
        return provideRetrofit().create<WeatherApi>(WeatherApi::class.java)
    }
}