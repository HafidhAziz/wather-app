package com.homework.mhafidhaziz.weatherapp.presentation.weather.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.homework.mhafidhaziz.weatherapp.R
import com.homework.mhafidhaziz.weatherapp.databinding.ItemForecastBinding
import com.homework.mhafidhaziz.weatherapp.network.entity.Forecast


/**
 * Created by mhafidhabdulaziz on 10/02/19.
 * weather-app
 * help.aziz@gmail.com
 * Copyright 2019
 */
class ForecastItemAdapter(private var forecastList: MutableList<Forecast>, private val context: Context) :
    RecyclerView.Adapter<ForecastItemAdapter.ForecastHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_forecast, parent, false)
        return ForecastHolder(view, context)
    }

    override fun onBindViewHolder(holder: ForecastHolder, position: Int) {
        holder.bindItem(forecastList[position])
    }

    override fun getItemCount(): Int = forecastList.size

    inner class ForecastHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {

        private var binding: ItemForecastBinding = DataBindingUtil.bind(itemView)

        fun bindItem(items: Forecast) {
            binding.textDay.text = items.day
            binding.textTemperature.text = context.resources.getString(R.string.info_celcius, items.temperature)
        }
    }
}