package com.trabelsimohamedsafwen.weather.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trabelsimohamedsafwen.weather.data.entities.WeatherObject
import com.trabelsimohamedsafwen.weather.data.entities.WeatherResponse
import com.trabelsimohamedsafwen.weather.data.remote.WeatherDataSource
import io.reactivex.rxkotlin.subscribeBy

class MainActivityViewModel (private var weatherDataSource: WeatherDataSource): ViewModel()
{
    private var _weatherDetails: MutableLiveData<WeatherResponse> = MutableLiveData()
    val weatherDetails : LiveData<WeatherResponse> =_weatherDetails
    fun fetchWeather()
    {
        weatherDataSource.fetchWeather().subscribeBy (onComplete = {},onError = {},onNext = {
            _weatherDetails.postValue(it)
            var filtredList= listOf<WeatherObject>()
            for (item in it.weatherList!!)
            {
                if(!filtredList.contains(item))
                {

                }

            }
        })
    }
}