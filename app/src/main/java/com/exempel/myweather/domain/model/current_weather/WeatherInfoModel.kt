package com.exempel.myweather.domain.model.current_weather

import com.exempel.myweather.domain.model.wind.WindDirection

data class WeatherInfoModel(
    val tempC: Float, //
    val isDay: Boolean,
    val windKph: Float,//
    val windDirection: WindDirection, //
    val pressureMb: Int, //
    val humidityPercent: Int,//
    val cloudPercent: Int, //
    val visibilityKm: Float, //
    val uvIndex: Int,
)