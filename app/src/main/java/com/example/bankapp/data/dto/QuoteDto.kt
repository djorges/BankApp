package com.example.bankapp.data.dto

import com.google.gson.annotations.SerializedName

data class QuoteDto(
    @SerializedName("BTC")
    val btc: CurrencyDto?,
    @SerializedName("ETH")
    val eth: CurrencyDto?,
    @SerializedName("USD")
    val usd: CurrencyDto?
)