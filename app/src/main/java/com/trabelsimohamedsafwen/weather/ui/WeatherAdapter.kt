package com.trabelsimohamedsafwen.weather.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.trabelsimohamedsafwen.weather.R
import com.trabelsimohamedsafwen.weather.data.entities.WeatherObject
import com.trabelsimohamedsafwen.weather.data.entities.WeatherResponse
import com.trabelsimohamedsafwen.weather.util.DateUtil
import kotlinx.android.synthetic.main.weather_item.view.*

class WeatherAdapter
    (var weatherList: ArrayList<WeatherObject>,
val itemClickListener: OnItemClickListener) :

RecyclerView.Adapter<WeatherAdapter.CommitViewHolder>() {
    fun updateWeatherList(newWeatherList: List<WeatherObject>) {
        weatherList.clear()
        if (weatherList != null) {
            weatherList.addAll(newWeatherList)
        }
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = CommitViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.weather_item, parent, false)
    )


    override fun getItemCount(): Int {
        return weatherList.size
    }

    override fun onBindViewHolder(holder: CommitViewHolder, position: Int) {
        holder.bind(weatherList[position],itemClickListener)
        (weatherList[position])

    }

    class CommitViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        private val weatherIcon= view.weather_image_view
        private val weatherTemp = view.temperature
        private val date = view.date


        private val rootView = view

        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(weather: WeatherObject, clickListener: OnItemClickListener) {


            weatherTemp.text = weather.mainDetails!!.temperature
            date.text = DateUtil.convertLongToTime(weather.currentDate.toLong())

            val options = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.mipmap.ic_launcher_round)
                .circleCrop()

            Glide.with(rootView)
                .setDefaultRequestOptions(options)
                .load("http://openweathermap.org/img/w/"+weather.weatherDetails[0].iconId+".png")
                .into(weatherIcon)
            itemView.setOnClickListener { clickListener.onItemClicked(weather) }


        }     }

    }
    interface OnItemClickListener{
        fun onItemClicked(weather: WeatherObject)
    }


