package com.homework.mhafidhaziz.weatherapp.presentation.weather

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.homework.mhafidhaziz.weatherapp.network.WeatherFactory
import com.homework.mhafidhaziz.weatherapp.network.entity.Weather
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */
class WeatherViewModel : ViewModel() {

    private lateinit var weatherFactory: WeatherFactory
    private var weatherData: MutableLiveData<Weather>? = null

    var bTemperature = ObservableField<String>()
    var bLocation = ObservableField<String>()

    fun getWeatherData(): LiveData<Weather> {
        if (weatherData == null)
            weatherData = MutableLiveData()
        return weatherData as LiveData<Weather>
    }

    fun getWeatherDataFromApi(location: String, weatherFact: WeatherFactory) {
        weatherFactory = weatherFact
        weatherFactory.registerObserver(object : Observer<Weather> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(weather: Weather) {
                weatherData?.value = weather
            }

            override fun onError(e: Throwable) {
                weatherData?.value = null
            }

            override fun onComplete() {

            }
        })
        weatherFactory.getData(location)
    }

    fun updateData(weather: Weather){
        weatherData.let {
            bTemperature.set(weather.temperature)
            bLocation.set(weather.location)
        }
    }
}