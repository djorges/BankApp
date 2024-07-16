package com.example.bankapp.data.dto

import com.google.gson.annotations.SerializedName

data class CryptoCurrenciesDto(
    @SerializedName("data")
    val cryptoDtoList: List<CryptoDto>,
    val status: StatusDto
)
