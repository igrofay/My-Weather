package com.exempel.myweather.domain.repos

import com.exempel.myweather.domain.model.current_weather.CurrentWeatherModel

interface WeatherRepos {
    suspend fun getCurrentWeatherCity(nameCity:String) : CurrentWeatherModel
    suspend fun getCurrentWeatherGeolocation(lat: String, lon: String) : CurrentWeatherModel
}