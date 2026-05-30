package com.example.tp3parcial.api.auth

data class LoginResponseDto(
    val success: Boolean,
    val token: String,
    val user: AuthUserDto
)

data class SignupResponseDto(
    val success: Boolean,
    val message: String,
    val token: String,
    val user: AuthUserDto
)
data class AuthUserDto(
    val id: Int,
    val fullName: String,
    val phone: String,
    val email: String,
    val avatar: String,
    val creditScore: Int,
    val availableBalance: Int,
    val memberSince: String
)

data class AuthRequestDto(
    val username: String,
    val password: String
)