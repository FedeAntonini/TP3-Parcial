package com.example.tp3parcial.api.loan

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoanApi {
    @GET("loans")
    suspend fun getLoans(): LoansResponseDto

    @POST("loans/apply")
    suspend fun applyLoan(@Body request: LoanApplyRequestDto): LoanApplyResponseDto
}

