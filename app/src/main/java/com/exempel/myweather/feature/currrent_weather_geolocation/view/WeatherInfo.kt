package com.exempel.myweather.feature.currrent_weather_geolocation.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.exempel.myweather.R
import com.exempel.myweather.domain.model.current_weather.WeatherConditionModel
import com.exempel.myweather.domain.model.current_weather.WeatherInfoModel
import com.exempel.myweather.feature.theme.ColorText
import com.exempel.myweather.feature.widget.LabelVertical
import kotlinx.datetime.Month

@Composable
fun WeatherInfo(
    weatherInfoModel: WeatherInfoModel
) {
    Column(
        modifier = Modifier.padding(15.dp)
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            LabelVertical(
                icon = painterResource(R.drawable.ic_temp),
                label = "Температура",
                label2 = "${weatherInfoModel.tempC} ℃",
                modifier = Modifier.weight(1f),
            )
            DicVertical()
            LabelVertical(
                icon = painterResource(R.drawable.ic_wind),
                label = "Ветер",
                label2 = "${weatherInfoModel.windKph} км/ч",
                modifier = Modifier.weight(1f),
            )
            DicVertical()
            LabelVertical(
                icon = painterResource(R.drawable.ic_cloud),
                label = "Облачность",
                label2 = "${weatherInfoModel.cloudPercent} %",
                modifier = Modifier.weight(1f),
            )
        }
        Divider(
            modifier = Modifier
                .padding(vertical = 10.dp),
            color = colors.ColorText.copy(0.8f),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            LabelVertical(
                icon = painterResource(R.drawable.ic_barometer),
                label = "Давление",
                label2 = "${weatherInfoModel.pressureMb} мбар",
                modifier = Modifier.weight(1f),
            )
            DicVertical()
            LabelVertical(
                icon = painterResource(R.drawable.ic_vane),
                label = "Направление",
                label2 = "${weatherInfoModel.windDirection}/${weatherInfoModel.windDirection.azimuthDegrees}º",
                modifier = Modifier.weight(1f),
            )
            DicVertical()
            LabelVertical(
                icon = painterResource(R.drawable.ic_humidity),
                label = "Влажность",
                label2 = "${weatherInfoModel.humidityPercent} %",
                modifier = Modifier.weight(1f),
            )
        }
        Divider(
            modifier = Modifier
                .padding(vertical = 10.dp),
            color = colors.ColorText.copy(0.8f),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            LabelVertical(
                icon = if(weatherInfoModel.isDay) painterResource(R.drawable.ic_sun)
                else painterResource(R.drawable.ic_moon),
                label = if(weatherInfoModel.isDay) "День"
                else "Ночь",
                modifier = Modifier.weight(1f),
            )
            DicVertical()
            LabelVertical(
                icon = painterResource(R.drawable.ic_eye),
                label = "Видимость",
                label2 = "${weatherInfoModel.visibilityKm} км",
                modifier = Modifier.weight(1f),
            )
            DicVertical()
            LabelVertical(
                icon = painterResource(R.drawable.ic_sun),
                label = "УФ-индекс",
                label2 = "${weatherInfoModel.uvIndex} uv",
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
private fun DicVertical(){
    Divider(
        color = colors.ColorText.copy(0.8f),
        modifier = Modifier
            .width(26.dp)
            .rotate(90f)
    )
}