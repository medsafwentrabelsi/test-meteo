package com.trabelsimohamedsafwen.weather.data.entities

import android.annotation.TargetApi
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherObject (
    @SerializedName("dt")
    var currentDate:String,
    @SerializedName("main")
    var mainDetails:WeatherDetailsObject?,
    @SerializedName("weather")
    var weatherDetails:List<WeatherMoreDetails>
): Serializable