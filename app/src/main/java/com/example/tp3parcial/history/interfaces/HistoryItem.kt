package com.example.tp3parcial.history.interfaces

import androidx.annotation.DrawableRes
import com.example.tp3parcial.R

// Fixed list of known types — only update this when new types are confirmed
enum class HistoryItemType(
    val label: String,
    @DrawableRes val iconRes: Int
) {
    TYPE(
        label = "Type",
        iconRes = R.drawable.chevron_right
    ),
    BALANCE(
        label = "Balance",
        iconRes = R.drawable.check
    ),
    PAID_BILLS(
        label = "Paid Bills",
        iconRes = R.drawable.arrow_upward
    ),
    ADDED(
        label = "Added",
        iconRes = R.drawable.add
    ),
    UNKNOWN(
        label = "Other",
        iconRes = R.drawable.chevron_right // fallback icon
    )
}

// Single data class — no need to subclass per type since the shape is the same
data class HistoryItem(
    val type: HistoryItemType,
    val time: String,
    val company: String,
    val amount: String,
)

data class HistorySection(
    val title: String,
    val items: List<HistoryItem>,
)
