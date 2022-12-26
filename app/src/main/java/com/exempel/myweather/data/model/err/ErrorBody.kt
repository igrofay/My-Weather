package com.exempel.myweather.data.model.err


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorBody(
    @SerialName("code")
    val code: Int,
    @SerialName("message")
    val message: String
)