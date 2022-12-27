package com.exempel.myweather.domain.model.current_weather

data class LocationModel(
    val lat: Double,
    val lon: Double,
    val country: String,
    val name: String,
    val tzId: String,
    val region: String,
    val urlImage: String,
)