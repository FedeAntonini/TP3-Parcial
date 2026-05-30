package com.example.tp3parcial.history.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3parcial.common.LinkText
import com.example.tp3parcial.history.interfaces.HistoryItemType
import com.example.tp3parcial.ui.theme.AppTheme

@Composable
fun TransactionDetailsView(
    amount: String,
    recipient: String,
    type: HistoryItemType,
    fee: String,
    dateTime: String,
    transactionNumber: String,
    onTransactionNumberClick: () -> Unit,
    onGoToHelpCenterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .background(color = MaterialTheme.colorScheme.secondary)
                .padding(20.dp)
        ) {
            Icon(
                painter = painterResource(type.iconRes),
                contentDescription = "",
                modifier = Modifier.size(20.dp),
            )
        }
        Spacer(modifier = Modifier.height(12.dp))

        if (type == HistoryItemType.PAID_BILLS) {
            Text(
                text = "Paid this month",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        Text(
            text = "$amount PHP",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "To $recipient",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.tertiary
        )

        Spacer(modifier = Modifier.height(16.dp))

        TransactionTypeBadge(type = type)

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Transaction Details",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

        TransactionDetailHistoryRow(
            label = "Fee", value = "₱$fee",
        )

        Spacer(modifier = Modifier.height(12.dp))

        TransactionDetailHistoryRow(label = "Date & Time", value = dateTime)

        Spacer(modifier = Modifier.height(12.dp))

        TransactionDetailHistoryRow(
            label = "Transaction Number",
            value = "#$transactionNumber",
            isLink = true,
            onValueClick = onTransactionNumberClick
        )

        Spacer(modifier = Modifier.height(24.dp))

        HorizontalDivider(color = Color(0xFFE5E2E1))

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Didn't find what you were looking for?",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(4.dp))

        LinkText(
            text = "Go to Help Center",
            onClick = onGoToHelpCenterClick,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 14.sp
        )
    }
}

@Composable
fun TransactionTypeBadge(type: HistoryItemType) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Text(
            text = type.label,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TransactionDetailScreenPreview() {
    AppTheme {
        TransactionDetailsView(
            amount = "1,255.00",
            recipient = "Apple Inc.",
            type = HistoryItemType.PAID_BILLS,
            fee = "100.00",
            dateTime = "Jul 15, 2024 9:12 AM",
            transactionNumber = "200412312551",
            onTransactionNumberClick = {},
            onGoToHelpCenterClick = {})
    }
}

@Composable
fun TransactionDetailHistoryRow(
    label: String,
    value: String,
    isLink: Boolean = false,
    onValueClick: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.tertiary,
            fontWeight = FontWeight.Normal
        )
        if (isLink && onValueClick != null) {
            LinkText(text = value, onClick = onValueClick, fontSize = 16.sp)
        } else {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Composable
fun ClickableText(text: String, onClick: () -> Unit) {
    Text(
        text = text, modifier = Modifier.clickable { onClick() })
}
