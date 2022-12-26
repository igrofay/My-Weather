package com.exempel.myweather.data.model.err


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrBody(
    @SerialName("error")
    val error: ErrorBody
)