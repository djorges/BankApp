package com.example.bankapp.presentation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bankapp.presentation.ui.composable.AccountSection
import com.example.bankapp.presentation.ui.composable.ActionsSection
import com.example.bankapp.presentation.ui.composable.CardsSection
import com.example.bankapp.presentation.ui.composable.TransactionsSection
import com.example.bankapp.presentation.ui.composable.UserBar
import com.example.bankapp.presentation.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
){
    val data by viewModel.response.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        UserBar()
        AccountSection()
        ActionsSection()
        CardsSection()
        TransactionsSection()
        //CurrenciesSection()
        //CryptoCurrenciesSection(data)
    }
}