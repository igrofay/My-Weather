package com.exempel.myweather.data.utils

import com.exempel.myweather.data.model.err.ErrBody
import com.exempel.myweather.domain.errors.Errors
import com.exempel.myweather.domain.errors.ProgramErrors
import com.exempel.myweather.domain.errors.RequestFailed

internal object WeatherApiErrorHandlerUtil {
    operator fun invoke(errBody: ErrBody) : Errors? {
        return when(errBody.error.code){
            1006 -> RequestFailed.NoFoundData
            2006, 2008-> ProgramErrors.AppNoLongerWorks()
            2007 -> ProgramErrors.AppIsTemporarilyUnavailable()
            9999 -> RequestFailed.ErrorServer
            else -> null
        }
    }
}