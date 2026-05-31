package com.example.tp3parcial.api.transaction

// TransactionDto.kt
data class TransactionDto(
    val id: String,
    val type: String,
    val title: String,
    val description: String,
    val amount: Int,
    val currency: String,
    val status: String,
    val date: String,
    val loanId: String?,
    val referenceNumber: String
)

data class PaginationDto(
    val page: Int,
    val limit: Int,
    val total: Int,
    val hasNextPage: Boolean
)

data class TransactionsResponseDto(
    val success: Boolean,
    val pagination: PaginationDto,
    val transactions: List<TransactionDto>
)