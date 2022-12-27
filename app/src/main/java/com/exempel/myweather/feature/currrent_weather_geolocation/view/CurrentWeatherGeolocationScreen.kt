package com.exempel.myweather.feature.currrent_weather_geolocation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.exempel.myweather.feature.currrent_weather_geolocation.model.CurrentWeatherGeolocationState
import com.exempel.myweather.feature.currrent_weather_geolocation.view_model.CurrentWeatherGeolocationVM
import com.exempel.myweather.feature.widget.LoadingContent

@Composable
fun CurrentWeatherGeolocationScreen(
    viewModel: CurrentWeatherGeolocationVM = hiltViewModel()
) {
    val state by remember { viewModel.state }
    when(state){
        CurrentWeatherGeolocationState.ConnectionError -> {}
        CurrentWeatherGeolocationState.Loading -> LoadingContent()
        is CurrentWeatherGeolocationState.Success -> DisplayCurrentWeatherInfo(
            weatherConditionModel = (state as CurrentWeatherGeolocationState.Success).weatherModel
        )
    }
}