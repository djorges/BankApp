package com.example.bankapp.data.dto

import com.google.gson.annotations.SerializedName

data class CryptoDto(
    val id: Int,
    val name: String?,
    val symbol: String?,
    val slug: String?,
    @SerializedName("cmc_rank")
    val cmcRank: Int?,
    @SerializedName("num_market_pairs")
    val numMarketPairs: Int?,
    @SerializedName("circulating_supply")
    val circulatingSupply: Double?,
    @SerializedName("self_reported_circulating_supply")
    val selfReportedCirculatingSupply: Double?,
    @SerializedName("total_supply")
    val totalSupply: Double?,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("date_added")
    val dateAdded: String?,
    @SerializedName("quote")
    val quotes: QuoteDto?
)
