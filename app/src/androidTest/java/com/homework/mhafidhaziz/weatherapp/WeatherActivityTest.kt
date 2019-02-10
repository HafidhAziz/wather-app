package com.homework.mhafidhaziz.weatherapp

import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.homework.mhafidhaziz.weatherapp.R.id.bottom_sheet
import com.homework.mhafidhaziz.weatherapp.R.id.forecastRecycler
import com.homework.mhafidhaziz.weatherapp.presentation.weather.WeatherActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */
@RunWith(AndroidJUnit4::class)
class WeatherActivityTest {

    @Rule
    @JvmField
    var weatherActivityTestRule = ActivityTestRule(WeatherActivity::class.java)

    @Test
    fun launch_weather_app_test() {
        delay()

        Espresso.onView(ViewMatchers.withId(bottom_sheet))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        delay()

        Espresso.onView(ViewMatchers.withId(forecastRecycler))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        delay()

    }

    private fun delay() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}