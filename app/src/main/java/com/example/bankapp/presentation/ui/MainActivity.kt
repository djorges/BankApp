package com.example.bankapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.bankapp.presentation.ui.composable.BottomNavigationBar
import com.example.bankapp.presentation.ui.screen.HomeScreen
import com.example.bankapp.presentation.ui.theme.BankAppTheme
import com.example.bankapp.presentation.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BankAppTheme(
                dynamicColor = true
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar()
                    }
                ) { innerPadding ->
                    HomeScreen(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}