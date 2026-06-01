package com.example.tp3parcial.api.product.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3parcial.api.UiState
import com.example.tp3parcial.api.product.ProductRepository
import com.example.tp3parcial.api.product.ProductsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {
    private val _products = MutableStateFlow<UiState<ProductsData>>(UiState.Loading)
    val products: StateFlow<UiState<ProductsData>> = _products

    init { getProducts() }

    fun getProducts() {
        viewModelScope.launch {
            _products.value = UiState.Loading
            repository.getProducts()
                .onSuccess { _products.value = UiState.Success(it) }
                .onFailure { _products.value = UiState.Error(it.message ?: "Unknown error") }
        }
    }
}