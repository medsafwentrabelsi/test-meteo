package com.trabelsimohamedsafwen.weather.data.remote

import com.trabelsimohamedsafwen.weather.data.entities.WeatherResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class WeatherDataSource {
    val weatherApi by lazy {
        WeatherApi.create();
    }

    fun fetchWeather(): Observable<WeatherResponse> {
        return Observable.create { emitter ->
            weatherApi.getWeather(
                apiKey = "8c6a392f4c4b7f8fb9a4b5240eddca9f",
                appId = "6455259",
                unit = "metric"
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                    onNext = {


                        if (it != null) {
                            emitter.onNext(it)
                        }
                    },
                    onError = { it.toString() },
                    onComplete = { println("Done!") }


                )
        }
    }
}