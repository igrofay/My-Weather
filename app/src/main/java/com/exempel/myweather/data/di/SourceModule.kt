package com.exempel.myweather.data.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.cache.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SourceModule {
//    private const val keySharedPreferences = "MyWeatherSharedPreferences"
    private const val urlServer = "https://api.weatherapi.com/"
    @Provides
    @Singleton
    fun provideHttpClient() : HttpClient {
        return HttpClient(Android){
            install(HttpRequestRetry) {
                retryOnServerErrors(maxRetries = 5)
                exponentialDelay()
            }
            install(Logging)
            install(HttpCache)
            install(ContentNegotiation) {
                json(Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            expectSuccess = true
            defaultRequest{
                url(urlServer)
            }
        }
    }
//    @Provides
//    @Singleton
//    fun provideSharedPreferences(@ActivityContext context: Context) : SharedPreferences {
//        return context.getSharedPreferences(keySharedPreferences, Context.MODE_PRIVATE)
//    }
}