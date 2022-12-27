package com.exempel.myweather.feature.currrent_weather_geolocation.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exempel.myweather.R
import com.exempel.myweather.domain.model.current_weather.LocationModel
import com.exempel.myweather.feature.utils.toDateString
import com.exempel.myweather.feature.widget.LabelHorizontal
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun LocationInfo(
    locationModel: LocationModel,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = locationModel.country,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = locationModel.name,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            LabelHorizontal(
                icon = painterResource(R.drawable.ic_time),
                label = Clock.System.now().toLocalDateTime(
                    TimeZone.of(locationModel.tzId)
                ).toDateString()
            )
            LabelHorizontal(
                icon = painterResource(R.drawable.ic_location),
                label = "${locationModel.lat}/${locationModel.lon}"
            )
        }
    }
}