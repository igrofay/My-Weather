package com.exempel.myweather.domain.errors

sealed class ProgramErrors: Errors(){
    class AppNoLongerWorks : ProgramErrors()
    class AppIsTemporarilyUnavailable : ProgramErrors()
}
