package com.example.tp3parcial.api.transaction

import retrofit2.http.GET

interface TransactionApi {
    @GET("transactions")
    suspend fun getTransactions(): TransactionsResponseDto
}