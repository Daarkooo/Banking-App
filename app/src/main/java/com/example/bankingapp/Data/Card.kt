package com.example.bankingapp.Data

import androidx.compose.ui.graphics.Brush

data class Card(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val cardBalance: Double,
    val color: Brush // for gradient colors
)
