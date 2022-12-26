package com.exempel.myweather.domain.model.current_weather

data class AirQualityModel(
    val co: Double,
    val gbDefraIndex: Int,
    val no2: Double,
    val o3: Double,
    val pm10: Double,
    val pm25: Double,
    val so2: Double,
    val usEpaIndex: Int
)