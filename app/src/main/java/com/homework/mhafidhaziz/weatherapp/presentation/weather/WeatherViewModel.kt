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
    private var error: MutableLiveData<Throwable>? = null
    private var loading: MutableLiveData<Boolean>? = null

    var bTemperature = ObservableField<String>()
    var bLocation = ObservableField<String>()
    var bShowError = ObservableField<Boolean>(false)
    var bShowLoadingView = ObservableField<Boolean>(true)

    fun getError(): LiveData<Throwable> {
        if (error == null) {
            error = MutableLiveData()
        }
        return error as LiveData<Throwable>
    }

    fun isLoading(): LiveData<Boolean> {
        if (loading == null)
            loading = MutableLiveData()
        return loading as LiveData<Boolean>
    }

    fun setLoading(boolean: Boolean) {
        loading?.value = boolean
    }

    fun showLoading() {
        bShowLoadingView.set(true)
    }

    fun hideLoading() {
        bShowLoadingView.set(false)
    }

    fun getWeatherData(): LiveData<Weather> {
        if (weatherData == null)
            weatherData = MutableLiveData()
        return weatherData as LiveData<Weather>
    }

    fun getWeatherDataFromApi(location: String, weatherFact: WeatherFactory) {
        weatherFactory = weatherFact
        weatherFactory.registerObserver(object : Observer<Weather> {
            override fun onSubscribe(d: Disposable) {
                setLoading(false)
            }

            override fun onNext(weather: Weather) {
                setLoading(false)
                weatherData?.value = weather
            }

            override fun onError(e: Throwable) {
                setLoading(false)
                error?.value = e
                weatherData?.value = null
            }

            override fun onComplete() {
                setLoading(false)
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