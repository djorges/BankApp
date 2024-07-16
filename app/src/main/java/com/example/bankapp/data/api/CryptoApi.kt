package com.example.bankapp.data.api

import com.example.bankapp.data.dto.CryptoCurrenciesDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {
    @GET("listings/latest")
    suspend fun getListingLatest(
        @Query("start") start: Int,
        @Query("limit") limit: Int,
        @Query("sort") sort: String = "market_cap",
        @Query("convert") convert: String = "USD",
        @Query("cryptocurrency_type") cryptocurrencyType: String = "all",
        @Query("tag") tagType: String = "all",
        @Query("aux") aux: String = "num_market_pairs,cmc_rank,date_added,tags,platform,max_supply,circulating_supply,total_supply"
    ): Response<CryptoCurrenciesDto>
}