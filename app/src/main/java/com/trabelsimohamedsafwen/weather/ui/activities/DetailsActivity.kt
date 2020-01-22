package com.trabelsimohamedsafwen.weather.ui.activities

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.trabelsimohamedsafwen.weather.R
import com.trabelsimohamedsafwen.weather.data.entities.WeatherObject
import com.trabelsimohamedsafwen.weather.util.DateUtil

import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    lateinit var  weather:WeatherObject
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
     weather= intent.getSerializableExtra("weather") as WeatherObject

window.addFlags(WindowManager.LayoutParams.FLAGS_CHANGED)
        initView()
    }
    private fun initView()
    {
        temperature_text_view_details.text= weather.mainDetails!!.temperature
        min_temp_text_view_details.text=weather.mainDetails!!.temp_min
        max_temp_text_view_details.text= weather.mainDetails!!.temp_max
        pressure_text_view_details.text=weather.mainDetails!!.pressure
        humidity_text_view_details.text=weather.mainDetails!!.humidity
        date_text_view_details.text=DateUtil.convertLongToTime(weather.currentDate.toLong())
        val options = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.mipmap.ic_launcher_round)
            .circleCrop()
        Glide.with(this)
            .setDefaultRequestOptions(options)
            .load("http://openweathermap.org/img/w/"+weather.weatherDetails[0].iconId+".png")
            .into(weather_image_view_details)

    }

}
