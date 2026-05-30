package com.example.tp3parcial.api.auth

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val api: AuthApi
) {
    suspend fun login(request: AuthRequestDto): Result<LoginResponseDto> = runCatching {
        api.login(request)
    }

    suspend fun signup(request: AuthRequestDto): Result<SignupResponseDto> = runCatching {
        api.signup(request)
    }
}