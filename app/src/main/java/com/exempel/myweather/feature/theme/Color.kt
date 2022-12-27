package com.exempel.myweather.feature.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

internal val Purple200 = Color(0xFFBB86FC)
internal val Purple500 = Color(0xFF6200EE)
internal val Purple700 = Color(0xFF3700B3)
internal val Teal200 = Color(0xFF03DAC5)

val While900 = Color(0xFFF4F4F5)
val Black900 = Color(0xFF272F3D)

val Colors.ColorText: Color
    get() = if (isLight) Black900 else While900