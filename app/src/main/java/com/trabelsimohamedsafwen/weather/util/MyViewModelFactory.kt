package com.trabelsimohamedsafwen.weather.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.trabelsimohamedsafwen.weather.data.remote.WeatherDataSource

class MyViewModelFactory(val weatherDataSource: WeatherDataSource) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(weatherDataSource::class.java).newInstance(weatherDataSource) as T
    }

}