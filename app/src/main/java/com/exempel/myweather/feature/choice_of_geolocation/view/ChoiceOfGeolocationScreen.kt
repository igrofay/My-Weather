package com.exempel.myweather.feature.choice_of_geolocation.view

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.exempel.myweather.feature.yandex_map.MapView

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ChoiceOfGeolocationScreen(
    searchWeatherGeolocation: (String)->Unit
) {
    var nameCity by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        MapView()
        InputCityForSearch(
            nameCity = nameCity,
            onChangeNameCity = { nameCity = it }
        )
        AnimatedVisibility(
            visible = nameCity.isNotBlank(),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-10).dp, y = (-30).dp),
            enter  = fadeIn() + scaleIn(),
            exit  = scaleOut() + fadeOut(),
        ) {
            FloatingActionButton(
                onClick = { searchWeatherGeolocation(nameCity) },
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .rotate(180f),
                    tint = Color.White
                )
            }
        }

    }
}