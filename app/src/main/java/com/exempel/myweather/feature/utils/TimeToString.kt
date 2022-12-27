package com.exempel.myweather.feature.utils

import kotlinx.datetime.LocalDateTime

fun LocalDateTime.toDateString() : String {
    return "$date ${String.format("%02d",time.hour)}:${String.format("%02d",time.minute)}"
}