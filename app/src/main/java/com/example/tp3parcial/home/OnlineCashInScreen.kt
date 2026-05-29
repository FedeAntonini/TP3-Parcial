package com.example.tp3parcial.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.navigation.Routes

// ── Data ──────────────────────────────────────────────────────────────────────
data class PaymentOption(val name: String, val category: String)

val bankOptions = listOf(
    PaymentOption("BPI", "BANKS"),
    PaymentOption("Chinabank", "BANKS"),
    PaymentOption("RCBC", "BANKS"),
    PaymentOption("Unionbank", "BANKS"),
)

val eWalletOptions = listOf(
    PaymentOption("GCash", "E-WALLETS"),
    PaymentOption("Pay Maya", "E-WALLETS"),
    PaymentOption("PayPal", "E-WALLETS"),
)

// ── Screen ────────────────────────────────────────────────────────────────────
@Composable
fun OnlineCashInScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CashInTopBar(
                title = "",
                onBack = { navController.popBackStack() }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            item {
                Text(
                    text = "Online Cash-In Options",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            item {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Search...") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            item {
                Text(
                    text = "BANKS",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(bankOptions.size) { index ->
                PaymentOptionItem(
                    option = bankOptions[index],
                    onClick = { navController.navigate(Routes.CASH_IN_AMOUNT) }
                )
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "E-WALLETS",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(eWalletOptions.size) { index ->
                PaymentOptionItem(
                    option = eWalletOptions[index],
                    onClick = { navController.navigate(Routes.CASH_IN_AMOUNT) }
                )
            }
        }
    }
}

// ── Item ──────────────────────────────────────────────────────────────────────
@Composable
fun PaymentOptionItem(option: PaymentOption, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = option.name.first().toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = option.name,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Icon(
            imageVector = Icons.Outlined.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
}

