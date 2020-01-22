package com.trabelsimohamedsafwen.weather.data.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDetailsObject(
    @SerializedName("temp")
    var temperature:String?,
    @SerializedName("feels_like")
    var feels:String?,
    @SerializedName("temp_min")
    var temp_min:String?,
    @SerializedName("temp_max")
    var temp_max: String?,
    @SerializedName("pressure")
    var pressure:String?,
    @SerializedName("humidity")
    var humidity:String
): Serializable