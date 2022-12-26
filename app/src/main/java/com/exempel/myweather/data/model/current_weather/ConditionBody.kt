package com.exempel.myweather.data.model.current_weather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ConditionBody(
    @SerialName("code")
    val code: Int,
    @SerialName("icon")
    val icon: String,
    @SerialName("text")
    val text: String
)