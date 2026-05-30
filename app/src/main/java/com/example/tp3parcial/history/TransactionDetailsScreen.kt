package com.example.tp3parcial.history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.common.RoundedBackButton
import com.example.tp3parcial.common.RoundedInfoButton
import com.example.tp3parcial.common.RoundedMoreHoriButton
import com.example.tp3parcial.history.components.HistoryView
import com.example.tp3parcial.history.components.TransactionDetailsView
import com.example.tp3parcial.history.interfaces.HistoryItemType
import com.example.tp3parcial.history.interfaces.sampleHistorySections
import com.example.tp3parcial.navigation.AppTopBar

@Composable
fun TransactionDetailsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { RoundedBackButton {} },
                rightComponent = {
                    Row() {
                        RoundedInfoButton { }
                        RoundedMoreHoriButton {  }
                    }
                }
            )
        }
    ) { padding ->
        TransactionDetailsView (
            amount = "1,255.00",
            recipient = "Apple Inc.",
            type = HistoryItemType.PAID_BILLS,
            fee = "100.00",
            dateTime = "Jul 15, 2024 9:12 AM",
            transactionNumber = "200412312551",
            onTransactionNumberClick = {},
            onGoToHelpCenterClick = {},
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp)
        )
    }
}