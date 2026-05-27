package com.example.tp3parcial.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.navigation.Routes

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier            = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text  = "Hello World",
            style = MaterialTheme.typography.headlineMedium,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick  = { navController.navigate(Routes.LOGIN) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Go to Login")
        }

        Button(
            onClick  = { navController.navigate(Routes.LOGIN_VERIFY) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Go to Verify Screen")
        }

        Button(
            onClick  = { navController.navigate(Routes.LOGIN_SMS) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Go to Sms Verification")
        }
    }
}