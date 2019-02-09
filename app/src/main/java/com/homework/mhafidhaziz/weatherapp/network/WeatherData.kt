package com.homework.mhafidhaziz.weatherapp.network

import android.util.Log
import com.homework.mhafidhaziz.weatherapp.common.Constants
import com.homework.mhafidhaziz.weatherapp.network.dto.WeatherDto
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */
class WeatherData(api: WeatherApi) {
    private val weatherApi: WeatherApi = api
    private var weatherDataModelObservable: Observer<WeatherDto>? = null

    fun registerObserver(weatherDataModelObservable: Observer<WeatherDto>) {
        this.weatherDataModelObservable = weatherDataModelObservable
    }

    fun callApi(location: String) {
        weatherApi.getWeather(Constants.API_KEY, location, Constants.DAY_COUNT)
            .observeOn(Schedulers.computation())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<WeatherDto> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(weather: WeatherDto) {
                    Log.i(">>>forecast", "SUCCESS")
                    weatherDataModelObservable!!.onNext(weather)
                }

                override fun onError(e: Throwable) {
                    Log.i(">>>forecast", e.toString())
                }

                override fun onComplete() {

                }
            })
    }
}