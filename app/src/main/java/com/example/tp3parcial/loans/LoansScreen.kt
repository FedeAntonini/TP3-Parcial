package com.example.tp3parcial.loans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.navigation.Routes
import com.example.tp3parcial.ui.theme.InteractiveAccent

@Composable
fun LoansScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item { LoansTopBar(navController) }
        item { Spacer(modifier = Modifier.height(8.dp)) }
        item { LoansBannerCard() }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { LoanDetailsCard() }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item { HowItWorksSection() }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                PillButton(
                    text = "Get This Loan",
                    onClick = { navController.navigate(Routes.LOANS_APPLY) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

// ── Top Bar ───────────────────────────────────────────────────────────────────
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoansTopBar(navController: NavController) {
    TopAppBar(
        title = { AppLogo(width = 80.dp) },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profile",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate(Routes.NOTIFICATIONS) }) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notifications",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            IconButton(onClick = { navController.navigate(Routes.LOANS_ACTIVE) }) {
                Icon(
                    imageVector = Icons.Outlined.CalendarMonth,
                    contentDescription = "Active Loans",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    )
}

// ── Banner Card ───────────────────────────────────────────────────────────────
@Composable
fun LoansBannerCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(20.dp)
    ) {
        Column {
            Surface(
                shape = RoundedCornerShape(50),
                color = InteractiveAccent.copy(alpha = 0.2f)
            ) {
                Text(
                    text = "Limited Time Offer",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = InteractiveAccent
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Safe and\nsecure loans",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "All here in Rayland",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// ── Loan Details Card ─────────────────────────────────────────────────────────
@Composable
fun LoanDetailsCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Text(
            text = "You can borrow up to",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "₱ 30,000.00",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "*Subject to evaluation",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LoanDetailItem(label = "Loan Details", value = "")
            TextButton(onClick = {}) {
                Text(
                    text = "What is this?",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LoanDetailItem(label = "Payable in", value = "6 - 12\nmonths")
            LoanDetailItem(label = "Interest Rate", value = "1.99%\nave per mo.")
            LoanDetailItem(label = "Process Fee", value = "3%\nas low as")
        }
    }
}

@Composable
fun LoanDetailItem(label: String, value: String) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (value.isNotEmpty()) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

// ── How It Works ──────────────────────────────────────────────────────────────
@Composable
fun HowItWorksSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "How it works",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        val items = listOf(
            "Keep your credit score high" to "The offered loan amount is based on your credit score",
            "Get instant approval" to "Everything we need to process is already in the application",
            "Easy payments option available" to "Skip the queue and pay your due on the application",
            "Safe and secure" to "Rayland is working with trusted partners to provide this services",
        )

        items.chunked(2).forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                row.forEach { (title, desc) ->
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = desc,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}