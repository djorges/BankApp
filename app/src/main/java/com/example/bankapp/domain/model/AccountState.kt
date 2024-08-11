package com.example.bankapp.domain.model

data class AccountState(
    val id:Int?,
    val type:String,
    val balance: Double,
    val currency: String
)