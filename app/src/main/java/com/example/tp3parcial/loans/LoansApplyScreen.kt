package com.example.tp3parcial.loans

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tp3parcial.common.BottomActionBar
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.navigation.Routes
import com.example.tp3parcial.ui.theme.InteractiveAccent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoansApplyScreen(navController: NavController) {
    var loanAmount by remember { mutableStateOf("2,000.00") }
    var selectedPlan by remember { mutableStateOf("6 Months") }
    var selectedPurpose by remember { mutableStateOf("Educational") }
    var purposeExpanded by remember { mutableStateOf(false) }

    val purposes = listOf("Educational", "Medical", "Business", "Personal", "Other")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Loan", fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Outlined.Info, contentDescription = "Info")
                    }
                }
            )
        },
        bottomBar = {
            BottomActionBar {
                PillButton(
                    text = "Get This Loan",
                    onClick = { navController.navigate(Routes.LOANS_SUCCESS) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Please provide your details\nfor your loan",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Please provide your details for your loan",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Step 1
            StepLabel(number = "1", title = "Enter loan amount")
            OutlinedTextField(
                value = loanAmount,
                onValueChange = { loanAmount = it },
                prefix = { Text("₱", fontWeight = FontWeight.Bold) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                shape = RoundedCornerShape(12.dp),
                singleLine = true
            )

            // Step 2
            StepLabel(number = "2", title = "Select an installment plan")
            InstallmentPlanCard(
                selected = selectedPlan == "6 Months",
                months = "6 Months",
                interest = "2.99% Interest",
                monthly = "₱ 982.12/mo",
                onClick = { selectedPlan = "6 Months" }
            )
            InstallmentPlanCard(
                selected = selectedPlan == "12 Months",
                months = "12 Months",
                interest = "2.99% Interest",
                monthly = "₱ 520.00/mo",
                onClick = { selectedPlan = "12 Months" }
            )

            // Step 3
            StepLabel(number = "3", title = "Select your loan purpose")
            ExposedDropdownMenuBox(
                expanded = purposeExpanded,
                onExpandedChange = { purposeExpanded = it }
            ) {
                OutlinedTextField(
                    value = selectedPurpose,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        Icon(Icons.Outlined.KeyboardArrowDown, contentDescription = null)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    shape = RoundedCornerShape(12.dp)
                )
                ExposedDropdownMenu(
                    expanded = purposeExpanded,
                    onDismissRequest = { purposeExpanded = false }
                ) {
                    purposes.forEach { purpose ->
                        DropdownMenuItem(
                            text = { Text(purpose) },
                            onClick = {
                                selectedPurpose = purpose
                                purposeExpanded = false
                            }
                        )
                    }
                }
            }

            // Summary
            SummaryCard(loanAmount = loanAmount)

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

// ── Componentes ───────────────────────────────────────────────────────────────
@Composable
fun StepLabel(number: String, title: String) {
    Column {
        Text(
            text = "Step $number",
            style = MaterialTheme.typography.labelSmall,
            color = InteractiveAccent,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun InstallmentPlanCard(
    selected: Boolean,
    months: String,
    interest: String,
    monthly: String,
    onClick: () -> Unit
) {
    val borderColor = if (selected) InteractiveAccent
    else MaterialTheme.colorScheme.outline

    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            brush = androidx.compose.ui.graphics.SolidColor(borderColor)
        ),
        color = if (selected) InteractiveAccent.copy(alpha = 0.08f)
        else MaterialTheme.colorScheme.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = months, fontWeight = FontWeight.Bold)
                Text(
                    text = interest,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = monthly,
                fontWeight = FontWeight.Bold,
                color = if (selected) InteractiveAccent
                else MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun SummaryCard(loanAmount: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(
            text = "Summary",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        SummaryRow("Loan Amount", "PHP $loanAmount")
        SummaryRow("3% Processing Fee", "-150.00")
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        SummaryRow("Total amount to Receive", "₱ $loanAmount", bold = true)
        SummaryRow("Lender", "null")
        Spacer(modifier = Modifier.height(4.dp))
        TextButton(onClick = {}) {
            Text("What is this?", color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
        }
    }
}

@Composable
fun SummaryRow(label: String, value: String, bold: Boolean = false) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = if (bold) FontWeight.Bold else FontWeight.Normal
        )
    }
}