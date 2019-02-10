package com.homework.mhafidhaziz.weatherapp.presentation.weather

import android.Manifest
import android.arch.lifecycle.Observer
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.homework.mhafidhaziz.weatherapp.R
import com.homework.mhafidhaziz.weatherapp.common.Constants
import com.homework.mhafidhaziz.weatherapp.databinding.ActivityWeatherBinding
import com.homework.mhafidhaziz.weatherapp.network.WeatherFactory
import com.homework.mhafidhaziz.weatherapp.presentation.WeatherApplication
import com.homework.mhafidhaziz.weatherapp.presentation.weather.adapter.ForecastItemAdapter
import java.util.*
import javax.inject.Inject

/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */

class WeatherActivity : AppCompatActivity(),
    WeatherView {

    @Inject
    lateinit var weatherFactory: WeatherFactory
    lateinit var binding: ActivityWeatherBinding
    private lateinit var viewModel: WeatherViewModel
    lateinit var forecastAdapter: ForecastItemAdapter

    companion object {
        private const val PERMISSION_REQUEST_LOCATION_CODE = 8
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApplication.getComponent()?.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather)
        binding.view = this
        binding.vm = WeatherViewModel()
        viewModel = binding.vm

        val mVerticalLayoutManager = LinearLayoutManager(this)
        mVerticalLayoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.forecastRecycler.layoutManager = mVerticalLayoutManager

        observeWeatherData()

    }

    private fun observeWeatherData() {
        viewModel.getWeatherData().observe(this, Observer { weather ->
            weather?.let {
                viewModel.updateData(it)
                forecastAdapter = ForecastItemAdapter(it.forecast.toMutableList(), this)
                binding.forecastRecycler.adapter = forecastAdapter
            }
            if(weather == null){
                showErrorScreen()
            }
        })
    }

    private fun checkAndGetCurrentLocation() {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager?

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager!!.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 10f, locationListener)
        } else {
            checkLocationPermission()
        }
    }

    private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            val gcd = Geocoder(this@WeatherActivity, Locale(Constants.LANGUAGE, Constants.COUNTRY))
            val addresses = gcd.getFromLocation(location.latitude, location.longitude, 1)
            if (addresses.size > 0) {
                viewModel.getWeatherDataFromApi("Bekasi", weatherFactory)
            }
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }

    private fun showErrorScreen() {
        //todo show error
    }

    private fun checkLocationPermission(): Boolean {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSION_REQUEST_LOCATION_CODE
                )
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    PERMISSION_REQUEST_LOCATION_CODE
                )
            }
            return false
        } else {
            return true
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_LOCATION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkAndGetCurrentLocation()
                } else {
                    Toast.makeText(this@WeatherActivity, R.string.message_denied_permission, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (checkLocationPermission()) {
            checkAndGetCurrentLocation()
        }
    }

}
