package com.example.bankapp.data.di

import com.example.bankapp.data.api.CryptoApi
import com.example.bankapp.data.repository.CryptoRepository
import com.example.bankapp.data.repository.CryptoRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module{
    single {
        Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single {
        val retrofit: Retrofit = get()
        retrofit.create(CryptoApi::class.java)
    }
    single<CryptoRepository>{
        CryptoRepositoryImpl(get())
    }
}