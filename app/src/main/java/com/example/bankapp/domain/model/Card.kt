package com.example.bankapp.domain.model

import androidx.compose.ui.graphics.Brush

data class Card(
    val id: Int,
    val type: CardType,
    val internationalMark: InternationalMarkType,
    val icon: Int,
    val number: String,
    val name: String,
    val balance: Double,
    val color: Brush
)

enum class CardType {
    CREDIT,
    DEBIT,
    PREPAID
}

enum class InternationalMarkType{
    VISA,
    MASTERCARD,
    AMERICAN_EXPRESS
}