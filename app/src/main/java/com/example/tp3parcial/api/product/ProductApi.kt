package com.example.tp3parcial.api.product

import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getProducts(): ProductsResponseDto
}

