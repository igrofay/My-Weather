package com.exempel.myweather.feature.currrent_weather_geolocation.model

import com.exempel.myweather.domain.model.current_weather.CurrentWeatherModel

sealed class CurrentWeatherGeolocationState{
    object Loading : CurrentWeatherGeolocationState()
    object ConnectionError: CurrentWeatherGeolocationState()
    class Success(val weatherModel: CurrentWeatherModel) : CurrentWeatherGeolocationState()
}
