package com.homework.mhafidhaziz.weatherapp.network

import com.homework.mhafidhaziz.weatherapp.network.dto.WeatherDto
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */
interface WeatherApi {
    @GET("forecast.json")
    fun getWeather(
        @Query("key") key: String,
        @Query("q") location: String,
        @Query("days") days: String
    ): Observable<WeatherDto>
}