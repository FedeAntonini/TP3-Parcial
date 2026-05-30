package com.example.tp3parcial.api.auth

import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: AuthRequestDto): LoginResponseDto

    @POST("auth/create")
    suspend fun signup(@Body request: AuthRequestDto): SignupResponseDto
}