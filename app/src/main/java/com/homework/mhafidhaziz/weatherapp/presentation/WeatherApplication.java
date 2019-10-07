package com.homework.mhafidhaziz.weatherapp.presentation;

import android.app.Application;

import com.homework.mhafidhaziz.weatherapp.di.component.AppComponent;
import com.homework.mhafidhaziz.weatherapp.di.component.DaggerAppComponent;
import com.homework.mhafidhaziz.weatherapp.di.module.AppModule;
import com.homework.mhafidhaziz.weatherapp.di.module.DataModule;
import com.homework.mhafidhaziz.weatherapp.di.module.NetworkModule;

/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */
public class WeatherApplication extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .dataModule(new DataModule())
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
