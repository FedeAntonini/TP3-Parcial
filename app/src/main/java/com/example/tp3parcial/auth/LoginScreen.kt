package com.example.tp3parcial.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.tp3parcial.api.UiState
import com.example.tp3parcial.auth.components.LoginView
import com.example.tp3parcial.auth.models.authentication.AuthViewModel
import com.example.tp3parcial.common.BottomActionBar
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.navigation.Graph


@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel
) {
    var password by remember { mutableStateOf("") }
    val loginState by viewModel.loginState.collectAsStateWithLifecycle()

    LaunchedEffect(loginState) {
        if (loginState is UiState.Success) {
            navController.navigate(Graph.HOME) {
                popUpTo(Graph.AUTH) { inclusive = true }
            }
        }
    }

    Scaffold(
        bottomBar = {
            BottomActionBar {
                PillButton(
                    text = "Log In",
                    onClick = { viewModel.login("mockeduser", password) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { padding ->
        LoginView(
            password = password,
            onPasswordChange = { password = it },
            modifier = Modifier.padding(padding)
        )
    }
}