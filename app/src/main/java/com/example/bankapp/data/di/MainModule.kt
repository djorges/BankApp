package com.example.bankapp.data.di

import com.example.bankapp.BuildConfig
import com.example.bankapp.data.api.CryptoApi
import com.example.bankapp.data.repository.CryptoRepository
import com.example.bankapp.data.repository.CryptoRepositoryImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module{
    single {
        OkHttpClient.Builder()
            .addNetworkInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("X-CMC_PRO_API_KEY", BuildConfig.API_KEY)
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/v1/cryptocurrency/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
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