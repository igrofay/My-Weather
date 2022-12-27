package com.exempel.myweather.feature.currrent_weather_geolocation.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exempel.myweather.domain.model.current_weather.CurrentWeatherModel
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DisplayCurrentWeatherInfo(
    weatherConditionModel: CurrentWeatherModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box {
                GlideImage(
                    imageModel = weatherConditionModel.location.urlImage,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                )
                Divider(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                )
                GlideImage(
                    imageModel = weatherConditionModel.condition.urlIcon,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .offset(y = 60.dp)
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(BorderStroke(2.dp, MaterialTheme.colors.primary), CircleShape)
                        .padding(5.dp),
                )
            }
        }
        item {
            LocationInfo(
                locationModel = weatherConditionModel.location,
            )
        }
        item {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Divider()
                Text(
                    text = weatherConditionModel.condition.messageWeather,
                    fontSize = 22.sp,
                    fontWeight = SemiBold,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Divider()
            }
        }
        item {
            WeatherInfo(weatherConditionModel.weatherInfo)
        }
    }
}