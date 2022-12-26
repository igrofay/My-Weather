package com.exempel.myweather.domain.model.current_weather

data class CurrentWeatherModel(
    val location: LocationModel,
    val condition: WeatherConditionModel,
    val airQuality: AirQualityModel,
    val weatherInfo: WeatherInfoModel,
)