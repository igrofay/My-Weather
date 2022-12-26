package com.exempel.myweather.data.repos

import com.exempel.myweather.data.data_source.weater.WeatherApi
import com.exempel.myweather.data.model.err.ErrBody
import com.exempel.myweather.data.utils.WeatherApiErrorHandlerUtil
import com.exempel.myweather.data.utils.toCurrentWeatherModel
import com.exempel.myweather.domain.errors.RequestFailed
import com.exempel.myweather.domain.model.current_weather.CurrentWeatherModel
import com.exempel.myweather.domain.repos.WeatherRepos
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.http.*
import io.ktor.http.HttpStatusCode.Companion.BadRequest
import io.ktor.http.HttpStatusCode.Companion.Forbidden
import io.ktor.http.HttpStatusCode.Companion.Unauthorized
import io.ktor.utils.io.errors.*
import java.util.*
import javax.inject.Inject

internal class WeatherReposImpl @Inject constructor(
    private val weatherApi: WeatherApi
): WeatherRepos {
    private val lang
    get() = Locale.getDefault().language
    override suspend fun getCurrentWeatherCity(nameCity: String): CurrentWeatherModel {
        try {
            val data = weatherApi.getCurrentWeather(nameCity,lang)
            return data.toCurrentWeatherModel()
        }catch (e: IOException){
            throw RequestFailed.ConnectionError
        }catch (e: ClientRequestException){
            when(e.response.status){
                HttpStatusCode.NotFound->{
                    val errBody = e.response.body<ErrBody>()
                    throw WeatherApiErrorHandlerUtil(errBody) ?: e
                }
                else -> throw e
            }
        }
    }

    override suspend fun getCurrentWeatherGeolocation(lat: String, lon: String): CurrentWeatherModel {
        try {
            val data = weatherApi.getCurrentWeather("$lat,$lon",lang)
            return data.toCurrentWeatherModel()
        }catch (e: IOException){
            throw RequestFailed.ConnectionError
        }catch (e: ClientRequestException){
            when(e.response.status){
                BadRequest,
                Forbidden,
                Unauthorized ->{
                    val errBody = e.response.body<ErrBody>()
                    throw WeatherApiErrorHandlerUtil(errBody) ?: e
                }
                else -> throw e
            }
        }
    }
}