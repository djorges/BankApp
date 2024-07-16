package com.example.bankapp.data.repository

import com.example.bankapp.data.api.BaseModel
import com.example.bankapp.data.api.CryptoApi
import com.example.bankapp.data.dto.CryptoCurrenciesDto

class CryptoRepositoryImpl(
    private val cryptoApi: CryptoApi
): CryptoRepository {
    override suspend fun getListingLatest(): BaseModel<CryptoCurrenciesDto>{
        cryptoApi.getListingLatest(start = 1, limit = 100).also {
            return if (it.isSuccessful) {
                BaseModel.Success(it.body()!!)
            } else {
                BaseModel.Error("An error has occurred")
            }
        }
    }
}