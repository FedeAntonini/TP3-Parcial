package com.example.tp3parcial.api.transaction.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3parcial.api.UiState
import com.example.tp3parcial.api.transaction.TransactionRepository
import com.example.tp3parcial.api.transaction.toHistorySections
import com.example.tp3parcial.history.interfaces.HistorySection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// TransactionViewModel.kt
@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val repository: TransactionRepository
) : ViewModel() {

    private val _transactions = MutableStateFlow<UiState<List<HistorySection>>>(UiState.Loading)
    val transactions: StateFlow<UiState<List<HistorySection>>> = _transactions

    init {
        getTransactions()
    }

    fun getTransactions() {
        viewModelScope.launch {
            _transactions.value = UiState.Loading
            repository.getTransactions()
                .onSuccess { _transactions.value = UiState.Success(it.toHistorySections()) }
                .onFailure { _transactions.value = UiState.Error(it.message ?: "Unknown error") }
        }
    }
}