package com.example.tp3parcial.api.transaction

import com.example.tp3parcial.history.interfaces.HistoryItem
import com.example.tp3parcial.history.interfaces.HistoryItemType
import com.example.tp3parcial.history.interfaces.HistorySection
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Transaction.kt
data class Transaction(
    val id: String,
    val type: String,
    val title: String,
    val description: String,
    val amount: Int,
    val currency: String,
    val status: String,
    val date: LocalDateTime,
    val loanId: String?,
    val referenceNumber: String
)

fun TransactionDto.toDomain() = Transaction(
    id = id,
    type = type,
    title = title,
    description = description,
    amount = amount,
    currency = currency,
    status = status,
    date = LocalDateTime.parse(date, DateTimeFormatter.ISO_DATE_TIME),
    loanId = loanId,
    referenceNumber = referenceNumber
)

fun String.toHistoryItemType() = when (this) {
    "LOAN_PAYMENT" -> HistoryItemType.PAID_BILLS
    "CASH_IN" -> HistoryItemType.ADDED
    "LOAN_DISBURSEMENT" -> HistoryItemType.BALANCE
    else -> HistoryItemType.UNKNOWN
}

fun Transaction.toHistoryItem() = HistoryItem(
    type = type.toHistoryItemType(),
    time = date.format(DateTimeFormatter.ofPattern("h:mm a")),
    company = title,
    amount = "%,.0f %s".format(amount.toDouble(), currency)
)

fun List<Transaction>.toHistorySections(): List<HistorySection> {
    val today = LocalDate.now()
    val todayTransactions = filter { it.date.toLocalDate() == today }
    val recentTransactions = filter { it.date.toLocalDate() != today }

    return buildList {
        if (todayTransactions.isNotEmpty()) {
            add(HistorySection(
                title = "Today",
                items = todayTransactions.map { it.toHistoryItem() }
            ))
        }
        if (recentTransactions.isNotEmpty()) {
            add(HistorySection(
                title = "Recent Loans",
                items = recentTransactions.map { it.toHistoryItem() }
            ))
        }
    }
}