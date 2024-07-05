package com.example.bankapp.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Currency(
    val id: Int,
    val name:String,
    val buy: Float,
    val sell: Float,
    val icon: ImageVector
)
