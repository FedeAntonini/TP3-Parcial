package com.example.tp3parcial.api.loan

data class LoansResponseDto(
    val success: Boolean,
    val loans: List<LoanDto>,
    val summary: LoanSummaryDto
)

data class LoanDto(
    val id: String,
    val lender: String,
    val lenderLogo: String,
    val amount: Double,
    val amountDue: Double,
    val installmentAmount: Double,
    val installmentPlan: String,
    val interestRate: Double,
    val purpose: String,
    val status: String,
    val nextPaymentDate: String?,
    val nextPaymentLabel: String? = null,
    val startDate: String,
    val endDate: String,
    val paidInstallments: Int,
    val totalInstallments: Int
)

data class LoanSummaryDto(
    val totalActive: Int,
    val totalPaid: Int,
    val totalAmountDue: Double
)

data class LoanApplyRequestDto(
    val amount: Double,
    val installmentPlan: String,
    val purpose: String
)

data class LoanApplyResponseDto(
    val success: Boolean,
    val message: String? = null
)

// Domain models
data class Loan(
    val id: String,
    val lender: String,
    val lenderLogo: String,
    val amount: Double,
    val amountDue: Double,
    val installmentAmount: Double,
    val installmentPlan: String,
    val status: String,
    val nextPaymentLabel: String?,
    val isPaid: Boolean
)

data class LoanSummary(
    val totalActive: Int,
    val totalPaid: Int,
    val totalAmountDue: Double
)

data class LoansData(
    val loans: List<Loan>,
    val summary: LoanSummary
)

fun LoanDto.toDomain() = Loan(
    id = id,
    lender = lender,
    lenderLogo = lenderLogo,
    amount = amount,
    amountDue = amountDue,
    installmentAmount = installmentAmount,
    installmentPlan = installmentPlan,
    status = status,
    nextPaymentLabel = nextPaymentLabel,
    isPaid = status == "PAID"
)

