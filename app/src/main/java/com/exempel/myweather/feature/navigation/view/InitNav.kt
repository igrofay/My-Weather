package com.exempel.myweather.feature.navigation.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.exempel.myweather.feature.choice_of_geolocation.view.ChoiceOfGeolocationScreen
import com.exempel.myweather.feature.currrent_weather_geolocation.view.CurrentWeatherGeolocationScreen
import com.exempel.myweather.feature.navigation.model.MainRouting

@Composable
internal fun InitNav() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainRouting.ChoiceOfGeolocation.route
    ) {
        composable(MainRouting.ChoiceOfGeolocation.route) {
            ChoiceOfGeolocationScreen {
                navController.navigate(MainRouting.CurrentWeatherGeolocation.argRoute(it))
            }
        }
        composable(
            MainRouting.CurrentWeatherGeolocation.argRoute(),
        ) {
            CurrentWeatherGeolocationScreen()
        }
    }
}