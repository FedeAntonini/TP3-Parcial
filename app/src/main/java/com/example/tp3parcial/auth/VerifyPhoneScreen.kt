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
import com.example.tp3parcial.auth.components.VerifyPhoneView
import com.example.tp3parcial.common.BackButton
import com.example.tp3parcial.common.BottomActionBar
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.common.RoundedInfoButton
import com.example.tp3parcial.navigation.AppTopBar
import com.example.tp3parcial.navigation.Routes


@Composable
fun VerifyPhoneScreen(navController: NavController) {
    var phoneNumber by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { BackButton({ navController.popBackStack() }) },
                rightComponent = { RoundedInfoButton {} }
            )
        },
        bottomBar = {
            BottomActionBar {
                PillButton(
                    text = "Send Code",
                    onClick = { navController.navigate(Routes.LOGIN_SMS) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { padding ->
        VerifyPhoneView(
            countryCode = countryCode,
            phoneNumber = phoneNumber,
            onCountryCodeChange = { countryCode = it },
            onPhoneNumberChange = { phoneNumber = it },
            onSendCode = { code, number -> /* navigate or call VM */ },
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
        )
    }
}