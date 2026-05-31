package com.example.tp3parcial.api.transaction

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepository @Inject constructor(
    private val api: TransactionApi
) {
    suspend fun getTransactions(): Result<List<Transaction>> = runCatching {
        api.getTransactions().transactions.map { it.toDomain() }
    }
}