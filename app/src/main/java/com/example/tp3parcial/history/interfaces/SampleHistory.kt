package com.example.tp3parcial.history.interfaces

val sampleHistorySections = listOf(
    HistorySection(
        title = "Today",
        items = listOf(
            HistoryItem(
                type = HistoryItemType.PAID_BILLS,
                time = "9:07 AM",
                company = "Apple Inc.",
                amount = "1,2555 PHP",
            ),
            HistoryItem(
                type = HistoryItemType.PAID_BILLS,
                time = "9:07 AM",
                company = "Apple Inc.",
                amount = "1,2555 PHP",
            ),
            HistoryItem(
                type = HistoryItemType.PAID_BILLS,
                time = "9:07 AM",
                company = "Apple Inc.",
                amount = "1,2555 PHP",
            ),
            HistoryItem(
                type = HistoryItemType.ADDED,
                time = "9:07 AM",
                company = "Apple Inc.",
                amount = "1,200 PHP",
            ),
            HistoryItem(
                type = HistoryItemType.PAID_BILLS,
                time = "9:07 AM",
                company = "Apple Inc.",
                amount = "1,200 PHP",
            ),
        ),
    ),
    HistorySection(
        title = "Recent Loans",
        items = listOf(
            HistoryItem(
                type = HistoryItemType.BALANCE,
                time = "02/08/2024",
                company = "Apple Inc.",
                amount = "Paid",
            ),
            HistoryItem(
                type = HistoryItemType.BALANCE,
                time = "02/08/2024",
                company = "Apple Inc.",
                amount = "Paid",
            ),
            HistoryItem(
                type = HistoryItemType.BALANCE,
                time = "02/08/2024",
                company = "Apple Inc.",
                amount = "Paid",
            ),
        ),
    ),
)