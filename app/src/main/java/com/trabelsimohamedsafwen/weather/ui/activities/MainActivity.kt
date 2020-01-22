package com.trabelsimohamedsafwen.weather.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.trabelsimohamedsafwen.weather.R
import com.trabelsimohamedsafwen.weather.data.entities.WeatherObject
import com.trabelsimohamedsafwen.weather.data.remote.WeatherDataSource
import com.trabelsimohamedsafwen.weather.ui.OnItemClickListener
import com.trabelsimohamedsafwen.weather.ui.WeatherAdapter
import com.trabelsimohamedsafwen.weather.util.MyViewModelFactory
import com.trabelsimohamedsafwen.weather.viewModel.MainActivityViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {
    override fun onItemClicked(weather: WeatherObject) {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra("weather",weather)
        startActivity(intent)

    }

    private lateinit var viewModel: MainActivityViewModel
    private val weatherAdapter = WeatherAdapter(arrayListOf(), this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        weather_list_main_activity.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = weatherAdapter


        }
        initEvent()


    }

    private fun initEvent() {
//Instance View Model
        viewModel = ViewModelProviders.of(this, MyViewModelFactory(WeatherDataSource()))
            .get(MainActivityViewModel::class.java)
        viewModel.fetchWeather();
        viewModel.weatherDetails.observe(this, Observer {
            if (it != null) {

                it.weatherList?.let { it1 -> weatherAdapter.updateWeatherList(it1) }
                }
    }
        )}

}
