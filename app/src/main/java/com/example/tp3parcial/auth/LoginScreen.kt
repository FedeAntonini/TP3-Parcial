package com.example.tp3parcial.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tp3parcial.common.BottomActionBar
import com.example.tp3parcial.common.PillButton


@Composable
fun LoginScreen(navController: NavController) {
    var password by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomActionBar {
                PillButton(
                    text = "Log In",
                    onClick = { /* TODO login */ },
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