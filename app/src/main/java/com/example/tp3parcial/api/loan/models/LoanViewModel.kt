package com.example.tp3parcial.api.loan.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3parcial.api.UiState
import com.example.tp3parcial.api.loan.LoanApplyRequestDto
import com.example.tp3parcial.api.loan.LoanRepository
import com.example.tp3parcial.api.loan.LoansData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoanViewModel @Inject constructor(
    private val repository: LoanRepository
) : ViewModel() {
    private val _loans = MutableStateFlow<UiState<LoansData>>(UiState.Loading)
    val loans: StateFlow<UiState<LoansData>> = _loans

    private val _applyState = MutableStateFlow<UiState<Boolean>?>(null)
    val applyState: StateFlow<UiState<Boolean>?> = _applyState

    init { getLoans() }

    fun getLoans() {
        viewModelScope.launch {
            _loans.value = UiState.Loading
            repository.getLoans()
                .onSuccess { _loans.value = UiState.Success(it) }
                .onFailure { _loans.value = UiState.Error(it.message ?: "Unknown error") }
        }
    }

    fun applyLoan(amount: Double, installmentPlan: String, purpose: String) {
        viewModelScope.launch {
            _applyState.value = UiState.Loading
            repository.applyLoan(LoanApplyRequestDto(amount, installmentPlan, purpose))
                .onSuccess { _applyState.value = UiState.Success(true) }
                .onFailure { _applyState.value = UiState.Error(it.message ?: "Unknown error") }
        }
    }
}

