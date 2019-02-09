package com.homework.mhafidhaziz.weatherapp.network;

import android.database.Observable;
import com.homework.mhafidhaziz.weatherapp.network.dto.WeatherDto;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */
public interface WeatherApi {
    @GET("forecast.json")
    Observable<WeatherDto> getWeather(@Query("key") String key,
                                      @Query("q") String location,
                                      @Query("days") String days);
}
