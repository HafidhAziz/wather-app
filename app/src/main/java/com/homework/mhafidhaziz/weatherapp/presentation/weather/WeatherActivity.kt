package com.homework.mhafidhaziz.weatherapp.presentation.weather

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.homework.mhafidhaziz.weatherapp.R
import com.homework.mhafidhaziz.weatherapp.databinding.ActivityWeatherBinding

/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */

class WeatherActivity : AppCompatActivity(),
    WeatherView {

    lateinit var binding: ActivityWeatherBinding
    private lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        binding.view = this
        binding.vm = WeatherViewModel()
        viewModel = binding.vm

//        checkAndGetCurrentLocation()
    }

}
