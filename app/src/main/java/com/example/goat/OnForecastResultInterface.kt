package com.example.goat

import com.example.goat.model.Forecast

interface OnForecastResultInterface {
    fun onForecastResult(forecast: Forecast)
}