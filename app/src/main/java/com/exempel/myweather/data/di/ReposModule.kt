package com.exempel.myweather.data.di

import com.exempel.myweather.data.repos.WeatherReposImpl
import com.exempel.myweather.domain.repos.WeatherRepos
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ReposModule {
    @Binds
    @Singleton
    abstract fun bind(weatherReposImpl: WeatherReposImpl) : WeatherRepos
}