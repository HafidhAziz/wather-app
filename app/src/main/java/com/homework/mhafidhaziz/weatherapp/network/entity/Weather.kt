package com.homework.mhafidhaziz.weatherapp.network.entity

import android.os.Parcelable
import com.homework.mhafidhaziz.weatherapp.network.dto.Forecastday
import kotlinx.android.parcel.Parcelize


/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */

data class Weather(
    var location: String,
    var temperature: String,
    var forecast: List<Forecast>
)