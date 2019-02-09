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
data class Location(
    var country: String,
    var lat: Double,
    var localtime: String,
    var localtime_epoch: Int,
    var lon: Double,
    var name: String,
    var region: String,
    var tz_id: String
) : Parcelable