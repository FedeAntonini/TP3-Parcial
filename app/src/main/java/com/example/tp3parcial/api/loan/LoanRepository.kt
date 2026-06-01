package com.example.tp3parcial.api.loan

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoanRepository @Inject constructor(
    private val api: LoanApi
) {
    suspend fun getLoans(): Result<LoansData> = runCatching {
        val response = api.getLoans()
        LoansData(
            loans = response.loans.map { it.toDomain() },
            summary = LoanSummary(
                totalActive = response.summary.totalActive,
                totalPaid = response.summary.totalPaid,
                totalAmountDue = response.summary.totalAmountDue
            )
        )
    }

    suspend fun applyLoan(request: LoanApplyRequestDto): Result<LoanApplyResponseDto> =
        runCatching { api.applyLoan(request) }
}

