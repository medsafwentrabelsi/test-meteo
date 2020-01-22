package com.trabelsimohamedsafwen.weather.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    companion object{
     fun convertLongToTime(time: Long): String {
         val sdf = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm")
         val date = java.util.Date(time * 1000)
         return sdf.format(date)

     }
    }
}