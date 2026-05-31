package com.example.tp3parcial.manage

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.tp3parcial.api.UiState
import com.example.tp3parcial.api.auth.models.AuthViewModel
import com.example.tp3parcial.api.user.models.UserViewModel
import com.example.tp3parcial.common.BackButton
import com.example.tp3parcial.manage.components.ManageCreditScoreView
import com.example.tp3parcial.navigation.AppTopBar

@Composable
fun ManageCreditScoreScreen(
    navController: NavController,
    authViewModel: AuthViewModel,
    viewModel: UserViewModel = hiltViewModel()
) {
    val uiState by viewModel.user.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.getUser(1) // mocked id for now
    }
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { BackButton({ navController.popBackStack() }) },
            )
        },
    ) { padding ->
        when (uiState) {
            is UiState.Loading -> CircularProgressIndicator()
            is UiState.Error -> Text((uiState as UiState.Error).message)
            is UiState.Success -> {
                val user = (uiState as UiState.Success).data
                ManageCreditScoreView(
                    modifier = Modifier
                        .padding(padding)
                        .padding(horizontal = 24.dp),
                    score = user.creditScore,
                    scoreLabel = user.creditLevel,
                    minScore = 300,
                    maxScore = 850,
                )
            }
        }
    }
}

