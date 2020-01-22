package com.trabelsimohamedsafwen.weather.data.entities

import com.google.gson.annotations.SerializedName

class WeatherResponse (
    @SerializedName("list")
    var weatherList: List<WeatherObject>?
)