package com.example.tp3parcial.loans

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.ui.theme.InteractiveAccent
import com.example.tp3parcial.ui.theme.InteractivePrimary

// ── Data ──────────────────────────────────────────────────────────────────────
data class ActiveLoan(
    val company: String,
    val product: String,
    val fee: String,
    val amount: String,
    val isPaid: Boolean = false
)

val sampleActiveLoans = listOf(
    ActiveLoan("Apple Inc.", "iPhone 15 Pro Max", "Fees of febuary", "1,255 PHP"),
    ActiveLoan("Apple Inc.", "iPhone 15 Pro Max", "Fees of febuary", "1,255 PHP"),
    ActiveLoan("Apple Inc.", "iPhone 15 Pro Max", "Fees of febuary", "1,255 PHP"),
)

val sampleRecentLoans = listOf(
    ActiveLoan("Apple Inc.", "iPhone 15 Pro Max", "02/08/2024", "Paid", isPaid = true),
    ActiveLoan("Apple Inc.", "iPhone 15 Pro Max", "02/08/2024", "Paid", isPaid = true),
    ActiveLoan("Apple Inc.", "iPhone 15 Pro Max", "02/08/2024", "Paid", isPaid = true),
)

// ── Screen ────────────────────────────────────────────────────────────────────
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoansActiveScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Outlined.CalendarMonth, contentDescription = "Calendar")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            item {
                Text(
                    text = "Active loans",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            item {
                Text(
                    text = "Present",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(sampleActiveLoans) { loan ->
                ActiveLoanItem(loan = loan)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Recent Loans",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(sampleRecentLoans) { loan ->
                ActiveLoanItem(loan = loan)
            }
        }
    }
}

// ── Item ──────────────────────────────────────────────────────────────────────
@Composable
fun ActiveLoanItem(loan: ActiveLoan) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Check,
                contentDescription = null,
                tint = if (loan.isPaid) InteractiveAccent
                else MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )
            Column {
                if (loan.isPaid) {
                    Text(
                        text = loan.fee,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Text(
                    text = loan.product,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = loan.company,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = loan.amount,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = if (loan.isPaid) InteractiveAccent
                else MaterialTheme.colorScheme.onBackground
            )
        }
    }
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
}

