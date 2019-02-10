package com.homework.mhafidhaziz.weatherapp.network.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */

@Parcelize
data class Day(
    var avghumidity: Double,
    var avgtemp_c: Double,
    var avgtemp_f: Double,
    var avgvis_km: Double,
    var avgvis_miles: Double,
    var condition: Condition,
    var maxtemp_c: Double,
    var maxtemp_f: Double,
    var maxwind_kph: Double,
    var maxwind_mph: Double,
    var mintemp_c: Double,
    var mintemp_f: Double,
    var totalprecip_in: Double,
    var totalprecip_mm: Double,
    var uv: Double
) : Parcelable