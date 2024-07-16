package com.example.bankapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankapp.data.api.BaseModel
import com.example.bankapp.data.dto.CryptoCurrenciesDto
import com.example.bankapp.data.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.future.future
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class MainViewModel : ViewModel(), KoinComponent {
    private val repository: CryptoRepository by inject()

    private val _response = MutableStateFlow<BaseModel<CryptoCurrenciesDto>>(BaseModel.Loading)
    val response = _response.asStateFlow()

    init {
        getListing()
    }

    private fun getListing() {
        try{
            viewModelScope.launch {
                _response.update { BaseModel.Loading }
                repository.getListingLatest().also{
                    _response.update{ it }
                }
            }
        }catch (e: Exception){
            _response.update { BaseModel.Error(e.message.toString()) }
        }
    }
}