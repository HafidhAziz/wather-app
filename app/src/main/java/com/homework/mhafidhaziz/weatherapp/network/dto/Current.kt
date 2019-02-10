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
data class Current(
    var cloud: Double,
    var condition: Condition,
    var feelslike_c: Double,
    var feelslike_f: Double,
    var humidity: Double,
    var is_day: Double,
    var last_updated: String,
    var last_updated_epoch: Double,
    var precip_in: Double,
    var precip_mm: Double,
    var pressure_in: Double,
    var pressure_mb: Double,
    var temp_c: Double,
    var temp_f: Double,
    var uv: Double,
    var vis_km: Double,
    var vis_miles: Double,
    var wind_degree: Double,
    var wind_dir: String,
    var wind_kph: Double,
    var wind_mph: Double
) : Parcelable