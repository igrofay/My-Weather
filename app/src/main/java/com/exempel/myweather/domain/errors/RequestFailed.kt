package com.exempel.myweather.domain.errors

sealed class RequestFailed : Errors(){
    object ConnectionError: RequestFailed()
    object NoFoundData: RequestFailed()
    object ErrorServer: RequestFailed()
}