package com.example.bankapp.data.dto

import com.google.gson.annotations.SerializedName

data class StatusDto(
    val timestamp: String?,
    @SerializedName("error_message")
    val errorCode: Int,
    @SerializedName("error_code")
    val errorMessage: String?,
    @SerializedName("elapsed")
    val elapsed: Int?,
    @SerializedName("credit_count")
    val creditCount: Int?,
)
