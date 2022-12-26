package com.exempel.myweather.data.model.current_weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CurrentWeatherBody(
    @SerialName("current")
    val current: CurrentBody,
    @SerialName("location")
    val location: LocationBody
)