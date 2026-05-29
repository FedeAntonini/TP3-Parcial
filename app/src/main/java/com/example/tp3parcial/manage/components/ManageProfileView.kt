package com.example.tp3parcial.manage.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3parcial.R
import com.example.tp3parcial.common.RoundedAvatarPlaceholderButton
import com.example.tp3parcial.manage.interfaces.ProfileMenuItem
import com.example.tp3parcial.ui.theme.AppTheme

@Composable
fun ManageProfileView(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),

        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(
            text = "Manage",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        AccountDetails()
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = "General",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.tertiary
            )
            HorizontalDivider(color = Color(0xFFE5E2E1))
            ProfileMenuItems()
            HorizontalDivider(color = Color(0xFFE5E2E1))
            ProfileMenuItemRow(
                item = ProfileMenuItem(R.drawable.log_out, "Log Out") { }
            )
        }

    }

}

@Composable
fun AccountDetails() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Currently using as",
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.tertiary
        )
        HorizontalDivider(color = Color(0xFFE5E2E1))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .height(56.dp)
        ) {
            EditButton(onClick = {}, modifier = Modifier.align(Alignment.TopEnd))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                RoundedAvatarPlaceholderButton(
                    onClick = { },
                    initials = "KB"
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = "Account details",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Text(
                        text = "Your personal Account",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
        }
    }
}

@Composable
fun EditButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(32.dp),
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF7BF179),
        )
    ) {
        Text(
            text = "Edit",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
fun ProfileMenuItems() {
    val profileMenuItems = listOf(
        ProfileMenuItem(R.drawable.account_details, "Account details") { },
        ProfileMenuItem(R.drawable.unread_mailbox, "Receiving by email or phone") { },
        ProfileMenuItem(R.drawable.scheduled_pay, "Scheduled pay") { },
        ProfileMenuItem(R.drawable.credit_score, "Credit score") { },
        ProfileMenuItem(R.drawable.settings, "Settings") { },
        ProfileMenuItem(R.drawable.terms_and_conditions, "Terms and Conditions") { },
        ProfileMenuItem(R.drawable.help, "Help") { },
    )
    Column(modifier = Modifier.fillMaxWidth()) {
        profileMenuItems.forEach { item ->
            ProfileMenuItemRow(item = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ManageProfileViewPreview() {
    AppTheme {
        ManageProfileView()
    }
}