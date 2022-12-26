package com.exempel.myweather.domain.model.wind

enum class WindDirection(
    val azimuthDegrees: Float
){
    N(0f),
    NNE(22.50f),
    NE(45.00f),
    ENE(67.50f),
    E(90.00f),
    ESE(112.50f),
    SE(135.00f),
    SSE(157.50f),
    S(180.00f),
    SSW(202.50f),
    SW(225.00f),
    WSW(247.50f),
    W(270.00f),
    WNW(292.50f),
    NW(315.00f),
    NNW(337.50f)
}