package com.example.tp3parcial.api.user.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3parcial.api.UiState
import com.example.tp3parcial.api.user.User
import com.example.tp3parcial.api.user.UserRepository
import com.example.tp3parcial.auth.data.TokenDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository,
    private val tokenDataStore: TokenDataStore
) : ViewModel() {
    private val _user = MutableStateFlow<UiState<User>>(UiState.Loading)
    val user: StateFlow<UiState<User>> = _user

    init {
        viewModelScope.launch {
            val userId = tokenDataStore.getUserId()
            if (userId != null) getUser(userId)
        }
    }

    fun getUser(id: Int) {
        viewModelScope.launch {
            _user.value = UiState.Loading
            repository.getUser(id)
                .onSuccess { _user.value = UiState.Success(it) }
                .onFailure { _user.value = UiState.Error(it.message ?: "Unknown error") }
        }
    }
}