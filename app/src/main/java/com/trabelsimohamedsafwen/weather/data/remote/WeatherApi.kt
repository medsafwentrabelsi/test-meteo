package com.trabelsimohamedsafwen.weather.data.remote

import com.trabelsimohamedsafwen.weather.data.entities.WeatherResponse
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface  WeatherApi{
    @GET("forecast")
    fun getWeather(@Query("id") appId: String?, @Query("APPID")apiKey:String?, @Query("units")unit:String?) : Observable<WeatherResponse>

    companion object {

        fun create() : WeatherApi {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .build()
            return retrofit.create(WeatherApi::class.java)
        }
    }
}