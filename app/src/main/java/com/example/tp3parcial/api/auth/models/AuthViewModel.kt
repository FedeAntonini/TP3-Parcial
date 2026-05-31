package com.example.tp3parcial.api.auth.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp3parcial.api.UiState
import com.example.tp3parcial.api.auth.AuthRepository
import com.example.tp3parcial.api.auth.AuthRequestDto
import com.example.tp3parcial.api.auth.LoginResponseDto
import com.example.tp3parcial.auth.data.TokenDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val tokenDataStore: TokenDataStore,
    private val authRepository: AuthRepository
) : ViewModel() {

    var isLoggedIn by mutableStateOf<Boolean?>(null)
        private set

    val loginState = MutableStateFlow<UiState<LoginResponseDto>?>(null)

    init {
        viewModelScope.launch {
            isLoggedIn = tokenDataStore.getToken() != null
        }
    }

    fun login(username: String, password: String) {
        viewModelScope.launch {
            authRepository.login(AuthRequestDto(username, password))
                .onSuccess {
                    tokenDataStore.saveToken(it.token)
                    tokenDataStore.saveUserId(it.user.id) // add this
                    isLoggedIn = true
                }
                .onFailure {
                    loginState.value = UiState.Error(it.message ?: "Unknown error")
                }
        }
    }

    fun logout() {
        viewModelScope.launch {
            tokenDataStore.clearToken()
            tokenDataStore.clearUserId() // add this
            isLoggedIn = false
        }
    }
}