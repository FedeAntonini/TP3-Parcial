package com.example.tp3parcial.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.navigation.Routes
import com.example.tp3parcial.ui.theme.InteractiveAccent
import com.example.tp3parcial.ui.theme.InteractivePrimary

// ── Data ──────────────────────────────────────────────────────────────────────
data class NotificationItem(
    val title: String,
    val body: String,
    val date: String,
    val isUrgent: Boolean = false
)

val sampleNotifications = listOf(
    NotificationItem(
        title = "Your due date is almost here!",
        body = "We'd like to remind you about your due date this month. Please pay this balance within the date to keep your credit score. Tap to pay.",
        date = "Mar 8",
        isUrgent = true
    ),
    NotificationItem(
        title = "Your due date is almost here!",
        body = "We'd like to remind you about your due date this month. Please pay this balance within the date to keep your credit score. Tap to pay.",
        date = "Mar 8",
        isUrgent = true
    ),
    NotificationItem(
        title = "Got a minute to help us out?",
        body = "We'd like to remind you about your due date this month. Please pay this balance within the date to keep your credit score. Tap to pay.",
        date = "Mar 8"
    ),
    NotificationItem(
        title = "Got a minute to help us out?",
        body = "We'd like to remind you about your due date this month. Please pay this balance within the date to keep your credit score. Tap to pay.",
        date = "Mar 8"
    ),
)

// ── Screen ────────────────────────────────────────────────────────────────────
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationsScreen(navController: NavController) {
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
                    IconButton(onClick = { navController.navigate(Routes.DUE_DATES) }) {
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
                    text = "Notification",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            item {
                Text(
                    text = "Today",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(sampleNotifications.take(2)) { notif ->
                NotificationItemView(notif)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Announcement",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            items(sampleNotifications.drop(2)) { notif ->
                NotificationItemView(notif)
            }
        }
    }
}

// ── Item ──────────────────────────────────────────────────────────────────────
@Composable
fun NotificationItemView(notif: NotificationItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Dot indicador
        Box(
            modifier = Modifier
                .padding(top = 6.dp)
                .size(8.dp)
                .clip(CircleShape)
                .then(
                    if (notif.isUrgent)
                        Modifier.padding(0.dp)
                    else Modifier
                ),
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier.size(8.dp),
                shape = CircleShape,
                color = if (notif.isUrgent) InteractiveAccent
                else MaterialTheme.colorScheme.surfaceVariant
            ) {}
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = notif.title,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = notif.body,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Text(
            text = notif.date,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
    HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
}

