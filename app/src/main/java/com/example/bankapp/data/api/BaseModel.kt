package com.example.bankapp.data.api

sealed class BaseModel<out T> {
    data class Success<out T>(val data: T) : BaseModel<T>()
    data class Error<out T>(val message: String) : BaseModel<T>()
    class Loading<out T> : BaseModel<T>()
}