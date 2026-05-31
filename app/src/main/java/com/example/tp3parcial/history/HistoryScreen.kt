package com.example.tp3parcial.history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.tp3parcial.api.UiState
import com.example.tp3parcial.api.transaction.models.TransactionViewModel
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.common.RoundedNotificationButton
import com.example.tp3parcial.common.RoundedProfileButton
import com.example.tp3parcial.history.components.HistoryView
import com.example.tp3parcial.navigation.AppTopBar

@Composable
fun HistoryScreen(
    navController: NavController,
    viewModel: TransactionViewModel = hiltViewModel()
) {
    val uiState by viewModel.transactions.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { RoundedProfileButton {} },
                centerComponent = { Box(modifier = Modifier.offset(y = 12.dp)) { AppLogo(width = 60.dp) } },
                rightComponent = { RoundedNotificationButton {} }
            )
        }
    ) { padding ->
        when (uiState) {
            is UiState.Loading -> CircularProgressIndicator()
            is UiState.Error -> Text((uiState as UiState.Error).message)
            is UiState.Success -> HistoryView(
                sections = (uiState as UiState.Success).data,
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 24.dp)
            )
        }
    }
}