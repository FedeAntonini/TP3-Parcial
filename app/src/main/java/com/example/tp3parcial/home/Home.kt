package com.example.tp3parcial.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.tp3parcial.api.UiState
import com.example.tp3parcial.api.loan.Loan
import com.example.tp3parcial.api.loan.models.LoanViewModel
import com.example.tp3parcial.api.user.User
import com.example.tp3parcial.api.user.models.UserViewModel
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.navigation.Routes
import com.example.tp3parcial.ui.theme.InteractiveAccent
import com.example.tp3parcial.ui.theme.InteractivePrimary

@Composable
fun HomeScreen(
    navController: NavController,
    userViewModel: UserViewModel = hiltViewModel(),
    loanViewModel: LoanViewModel = hiltViewModel()
) {
    val userState by userViewModel.user.collectAsStateWithLifecycle()
    val loansState by loanViewModel.loans.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        item { TopBar(navController) }
        item { Spacer(modifier = Modifier.height(16.dp)) }

        item {
            when (userState) {
                is UiState.Loading -> Box(
                    modifier = Modifier.fillMaxWidth().height(120.dp),
                    contentAlignment = Alignment.Center
                ) { CircularProgressIndicator() }
                is UiState.Error -> Text(
                    text = (userState as UiState.Error).message,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.error
                )
                is UiState.Success -> {
                    val user = (userState as UiState.Success<User>).data
                    BalanceCard(
                        balance = "₱ ${String.format("%,.2f", user.availableBalance.toDouble())}",
                        onCashInClick = { navController.navigate(Routes.CASH_IN) }
                    )
                }
            }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }

        item {
            when (loansState) {
                is UiState.Loading -> Box(
                    modifier = Modifier.fillMaxWidth().height(80.dp),
                    contentAlignment = Alignment.Center
                ) { CircularProgressIndicator() }
                is UiState.Error -> Text(
                    text = (loansState as UiState.Error).message,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.error
                )
                is UiState.Success -> {
                    val data = (loansState as UiState.Success).data
                    val activeLoans = data.loans.filter { !it.isPaid }
                    if (activeLoans.isNotEmpty()) {
                        UnpaidLoansSection(loans = activeLoans)
                    }
                }
            }
        }

        item { Spacer(modifier = Modifier.height(24.dp)) }
        item { RecommendedSection() }
    }
}

// ── Top Bar ───────────────────────────────────────────────────────────────────
@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Outlined.Person,
            contentDescription = "Profile",
            tint = MaterialTheme.colorScheme.onBackground
        )
        AppLogo(width = 80.dp)
        IconButton(onClick = { navController.navigate(Routes.NOTIFICATIONS) }) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notifications",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

// ── Balance Card ──────────────────────────────────────────────────────────────
@Composable
fun BalanceCard(balance: String, onCashInClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    ) {
        Text(
            text = "Account",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "AVAILABLE BALANCE",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = balance,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Button(
                onClick = onCashInClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = InteractiveAccent,
                    contentColor = InteractivePrimary
                ),
                shape = RoundedCornerShape(50),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text("+ Cash In", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
        }
    }
}

// ── Unpaid Loans ──────────────────────────────────────────────────────────────
@Composable
fun UnpaidLoansSection(loans: List<Loan>) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        SectionHeader(title = "Unpaid Loans", onSeeAll = {})
        Spacer(modifier = Modifier.height(12.dp))
        loans.forEach { loan ->
            UnpaidLoanItem(loan = loan)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun UnpaidLoanItem(loan: Loan) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(InteractiveAccent.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = loan.lender.first().toString(),
                    fontWeight = FontWeight.Bold,
                    color = InteractiveAccent,
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = loan.lender,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = loan.nextPaymentLabel ?: "",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Text(
            text = "₱${String.format("%,.2f", loan.amountDue)}",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

// ── Recommended ───────────────────────────────────────────────────────────────
@Composable
fun RecommendedSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        SectionHeader(title = "Recommended For You", onSeeAll = {})
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(3) {
                Box(
                    modifier = Modifier
                        .width(120.dp)
                        .height(160.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    Text("📱", fontSize = 32.sp)
                }
            }
        }
    }
}

// ── Section Header ────────────────────────────────────────────────────────────
@Composable
fun SectionHeader(title: String, onSeeAll: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = onSeeAll) {
            Text(
                text = "See All →",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}