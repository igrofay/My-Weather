package com.exempel.myweather.data.data_source.weater

import com.exempel.myweather.data.model.current_weather.CurrentWeatherBody
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class WeatherApi @Inject constructor(
    private val httpClient: HttpClient,
){
    private val defaultParameters = "?key=694fcedae44e43a5a01190321221812&aqi=yes"
    suspend fun getCurrentWeather(location:String, lang: String): CurrentWeatherBody{
        return httpClient.get("/v1/current.json$defaultParameters&q=$location&lang=$lang").body()
    }
}