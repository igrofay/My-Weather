package com.exempel.myweather.data.utils

import com.exempel.myweather.data.model.current_weather.CurrentWeatherBody
import com.exempel.myweather.domain.model.current_weather.*
import com.exempel.myweather.domain.model.wind.WindDirection

internal fun CurrentWeatherBody.toCurrentWeatherModel() : CurrentWeatherModel{
    val locationModel = LocationModel(
        lat = location.lat,
        lon = location.lon,
        country = location.country,
        name = location.name,
        tzId = location.tzId,
        region = location.region,
    )
    val airQualityBody = current.airQuality
    val airQualityModel = AirQualityModel(
        co = airQualityBody.co,
        gbDefraIndex = airQualityBody.gbDefraIndex,
        no2 = airQualityBody.no2,
        o3 = airQualityBody.o3,
        pm10 = airQualityBody.pm10,
        pm25 = airQualityBody.pm25,
        so2 = airQualityBody.so2,
        usEpaIndex = airQualityBody.usEpaIndex,
    )
    val conditionModel = WeatherConditionModel(
        current.condition.text,
        "https:"+current.condition.icon.split("64x64").joinToString("128x128")
    )
    val weatherInfoModel = WeatherInfoModel(
        tempC = current.tempC.toFloat(),
        isDay = current.isDay==1,
        windKph = current.windKph.toFloat(),
        windDirection = WindDirection.valueOf(current.windDir),
        pressureMb = current.pressureMb.toInt(),
        humidityPercent = current.humidity,
        cloudPercent = current.cloud,
        visibilityKm = current.visKm.toFloat(),
        uvIndex = current.uv.toInt()
    )
    return CurrentWeatherModel(
        location = locationModel,
        condition = conditionModel,
        airQuality = airQualityModel,
        weatherInfo = weatherInfoModel
    )
}