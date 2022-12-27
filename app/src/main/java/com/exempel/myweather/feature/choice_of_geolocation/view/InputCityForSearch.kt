package com.exempel.myweather.feature.choice_of_geolocation.view

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputCityForSearch(
    nameCity: String,
    onChangeNameCity: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(15))
            .background(MaterialTheme.colors.secondary)
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier.size(34.dp),
            tint = Color.White
        )
        BasicTextField(
            value = nameCity,
            onValueChange = onChangeNameCity,
            modifier = Modifier
                .weight(1f)
                .height(34.dp),
            cursorBrush = SolidColor(Color.White),
            singleLine = true,
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp)
        ) { innerTextField ->
            Box(
                modifier = Modifier.height(34.dp),
                contentAlignment = Alignment.CenterStart
            ){
                if (nameCity.isEmpty())
                    Text(
                        text = "Имя города на английском",
                        color = Color.White.copy(0.7f),
                        fontSize = 16.sp
                    )
                innerTextField()
            }

        }
        AnimatedVisibility(
            visible = nameCity.isNotEmpty(),
            modifier = Modifier.size(34.dp),
            enter = fadeIn() + expandHorizontally(expandFrom = Alignment.Start),
            exit = fadeOut() + shrinkHorizontally(shrinkTowards = Alignment.Start),
        ) {
            IconButton(onClick = { onChangeNameCity("") }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    modifier = Modifier.size(34.dp),
                    tint = Color.White
                )
            }
        }
    }
}