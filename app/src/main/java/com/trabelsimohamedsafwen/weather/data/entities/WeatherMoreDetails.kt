package com.trabelsimohamedsafwen.weather.data.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherMoreDetails(

    @SerializedName("description")
var description : String?,
    @SerializedName("icon")

    var iconId:String?
): Serializable