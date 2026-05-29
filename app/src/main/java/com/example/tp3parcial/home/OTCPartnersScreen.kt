package com.example.tp3parcial.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
data class OTCPartner(val name: String, val maxAmount: String)

val otcPartners = listOf(
    OTCPartner("7-Eleven",        "Max. Transaction amount \$5,000"),
    OTCPartner("Cebuana Lhuillier","Max. Transaction amount \$5,000"),
    OTCPartner("LBC",             "Max. Transaction amount \$5,000"),
    OTCPartner("M Lhuillier",     "Max. Transaction amount \$5,000"),
)

// ── Screen ────────────────────────────────────────────────────────────────────
@Composable
fun OTCPartnersScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CashInTopBar(
                title = "",
                onBack = { navController.popBackStack() }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Over-The-Counter Partners",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            otcPartners.forEach { partner ->
                OTCPartnerItem(
                    partner = partner,
                    onClick = { navController.navigate(Routes.CASH_IN_AMOUNT) }
                )
            }
        }
    }
}

// ── Item ──────────────────────────────────────────────────────────────────────
@Composable
fun OTCPartnerItem(partner: OTCPartner, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = partner.name.first().toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = partner.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = partner.maxAmount,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Icon(
            imageVector = Icons.Outlined.ChevronRight,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
}

