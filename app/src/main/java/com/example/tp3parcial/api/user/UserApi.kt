package com.example.tp3parcial.api.user

import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: Int): UserResponseDto
}