package com.exempel.myweather.feature.navigation.model

sealed class MainRouting(val route: String){
    object ChoiceOfGeolocation : MainRouting("select_geolocation")
    object CurrentWeatherGeolocation: MainRouting("current_weather_geolocation")
}