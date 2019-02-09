package com.homework.mhafidhaziz.weatherapp.network

import com.homework.mhafidhaziz.weatherapp.network.dto.WeatherDto
import com.homework.mhafidhaziz.weatherapp.network.entity.Forecast
import com.homework.mhafidhaziz.weatherapp.network.entity.Weather
import com.homework.mhafidhaziz.weatherapp.presentation.WeatherApplication
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */
class WeatherFactory {
    @Inject
    lateinit var weatherData: WeatherData
    private var observer: Observer<Weather>? = null

    init {
        WeatherApplication.getComponent()?.inject(this)

        weatherData.registerObserver(object : Observer<WeatherDto> {

            override fun onNext(weatherDto: WeatherDto) {
                observer!!.onNext(convertData(weatherDto))
            }

            override fun onSubscribe(d: Disposable) {

            }
            override fun onError(e: Throwable) {

            }

            override fun onComplete() {

            }
        })
    }

    fun getData(location: String) {
        weatherData.callApi(location)
    }

    private fun convertData(weatherDto: WeatherDto): Weather {
        val forecasts = ArrayList<Forecast>()
        for (forecastDay in weatherDto.forecast.forecastday) {
            val forecast = Forecast(formatDate(forecastDay.date), forecastDay.day.avgtemp_c.toString())
            forecasts.add(forecast)
        }

        return Weather(weatherDto.current.feelslike_c.toString(), weatherDto.location.name, forecasts)
    }

    private fun formatDate(dateString: String): String {
        var day = ""
        try {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd", Locale("ID"))
            val date = simpleDateFormat.parse(dateString)
            val simpleDateFormatDay = SimpleDateFormat("EEEE", Locale("ID"))
            day = simpleDateFormatDay.format(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return day
    }

    fun registerObserver(observer: Observer<Weather>) {
        this.observer = observer
    }
}