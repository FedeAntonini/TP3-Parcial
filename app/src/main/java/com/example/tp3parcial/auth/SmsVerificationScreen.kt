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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.auth.components.SmsVerificationView
import com.example.tp3parcial.common.BackButton
import com.example.tp3parcial.common.BottomActionBar
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.common.RoundedInfoButton
import com.example.tp3parcial.navigation.AppTopBar


@Composable
fun SmsVerificationScreen(navController: NavController, phoneNumber: String = "1234567890") {
    var code by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { BackButton { } },
                rightComponent = { RoundedInfoButton {} }
            )
        },
        bottomBar = {
            BottomActionBar {
                PillButton(
                    text = "Next",
                    onClick = { /* TODO login */ },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { padding ->
        SmsVerificationView(
            phoneNumber = phoneNumber,
            code = code,
            onCodeChange = { code = it },
            onResendCode = { /* TODO resend */ },
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp)
        )
    }
}