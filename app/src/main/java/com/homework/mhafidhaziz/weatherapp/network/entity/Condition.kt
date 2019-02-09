package com.homework.mhafidhaziz.weatherapp.network.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */

@Parcelize
data class Condition(
    var code: Int,
    var icon: String,
    var text: String
) : Parcelable