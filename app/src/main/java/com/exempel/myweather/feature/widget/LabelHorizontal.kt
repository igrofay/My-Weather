package com.exempel.myweather.feature.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exempel.myweather.feature.theme.ColorText

@Composable
fun LabelHorizontal(
    icon: Painter,
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colors.secondary
        )
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colors.ColorText
        )
    }
}

@Composable
fun LabelVertical(
    icon: Painter,
    label: String,
    modifier: Modifier = Modifier,
    label2: String?= null,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        Text(
            text = label,
            maxLines = 1,
            overflow = TextOverflow.Clip,
            color = MaterialTheme.colors.ColorText
        )
        label2?.let {
            Text(
                text = it,
                maxLines = 1,
                overflow = TextOverflow.Clip,
                color = MaterialTheme.colors.ColorText
            )
        }
    }
}