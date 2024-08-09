package com.example.bankapp.data.repository

import com.example.bankapp.data.api.BaseModel
import com.example.bankapp.data.api.CryptoApi
import com.example.bankapp.data.dto.CryptoCurrenciesDto

class CryptoRepositoryImpl(
    private val cryptoApi: CryptoApi
): CryptoRepository {
    override suspend fun getListingLatest(): CryptoCurrenciesDto{
        return cryptoApi.getListingLatest(start = 1, limit = 50)
    }
}