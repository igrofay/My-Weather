package com.exempel.myweather.feature.navigation.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.exempel.myweather.feature.navigation.model.MainRouting

@Composable
internal fun InitNav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainRouting.ChoiceOfGeolocation.route
    ) {
        composable(MainRouting.ChoiceOfGeolocation.route){

        }
        composable(MainRouting.CurrentWeatherGeolocation.route){

        }
    }
}