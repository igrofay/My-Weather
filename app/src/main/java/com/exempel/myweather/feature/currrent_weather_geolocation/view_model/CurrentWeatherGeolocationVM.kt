package com.exempel.myweather.feature.currrent_weather_geolocation.view_model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exempel.myweather.domain.errors.RequestFailed
import com.exempel.myweather.domain.repos.WeatherRepos
import com.exempel.myweather.feature.currrent_weather_geolocation.model.CurrentWeatherGeolocationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherGeolocationVM @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val weatherRepos: WeatherRepos,
) : ViewModel() {
    private val _state =
        mutableStateOf<CurrentWeatherGeolocationState>(CurrentWeatherGeolocationState.Loading)
    val state: State<CurrentWeatherGeolocationState> by ::_state

    init {
        val nameCity = savedStateHandle.get<String>("nameCity")!!
        loadingCurrentWeather(nameCity)
    }

    private fun loadingCurrentWeather(nameCity: String) {
        viewModelScope.launch(
            Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
                Log.e(
                    "CurrentWeatherGeolocationVM::",
                    throwable.message.toString()
                )
            }
        ) {
            runCatching { weatherRepos.getCurrentWeatherCity(nameCity) }
                .onSuccess {
                    withContext(Dispatchers.Main){
                        _state.value = CurrentWeatherGeolocationState.Success(it)
                    }
                }
                .onFailure(::onError)
        }
    }

    private fun onError(throwable: Throwable){
        when(throwable){
            RequestFailed.ConnectionError ->
                _state.value = CurrentWeatherGeolocationState.ConnectionError
            else -> Log.e(
                "CurrentWeatherGeolocationVM::",
                throwable.message.toString()
            )
        }
    }
}