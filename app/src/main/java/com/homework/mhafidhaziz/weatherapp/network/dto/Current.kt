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
    var cloud: Int,
    var condition: Condition,
    var feelslike_c: Double,
    var feelslike_f: Double,
    var humidity: Int,
    var is_day: Int,
    var last_updated: String,
    var last_updated_epoch: Int,
    var precip_in: Int,
    var precip_mm: Double,
    var pressure_in: Double,
    var pressure_mb: Int,
    var temp_c: Int,
    var temp_f: Int,
    var uv: Int,
    var vis_km: Int,
    var vis_miles: Int,
    var wind_degree: Int,
    var wind_dir: String,
    var wind_kph: Int,
    var wind_mph: Double
) : Parcelable