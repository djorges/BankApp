package com.example.bankapp.data.repository

import com.example.bankapp.data.api.BaseModel
import com.example.bankapp.data.dto.CryptoCurrenciesDto

interface CryptoRepository {
    suspend fun getListingLatest(): CryptoCurrenciesDto
}