package com.example.bankapp.data.dto

import com.google.gson.annotations.SerializedName

data class CurrencyDto(
    @SerializedName("fully_diluted_market_cap")
    val fullyDilutedMarketCap: Double?,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("market_cap")
    val marketCap: Float?,
    @SerializedName("market_cap_dominance")
    val marketCapDominance: Float?,
    @SerializedName("percent_change_1h")
    val percentChange1h: Float?,
    @SerializedName("percent_change_24h")
    val percentChange24h: Float?,
    @SerializedName("percent_change_7d")
    val percentChange7d: Float?,
    @SerializedName("price")
    val price: Float?,
    @SerializedName("volume_24h")
    val volume24h: Float?,
    @SerializedName("volume_change_24h")
    val volumeChange24h: Float?
)