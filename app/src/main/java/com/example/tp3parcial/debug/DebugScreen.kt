package com.example.tp3parcial.debug

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.tp3parcial.navigation.Routes

@Composable
fun DebugScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Button(
                onClick = { navController.navigate(Routes.HISTORY) }) {
                Text(text = "To History Screen")
            }
            Button(onClick = { navController.navigate(Routes.HISTORY_TRANSACTION) }) {
                Text(text = "To History Transaction")
            }
            Button(onClick = { navController.navigate(Routes.ONBOARDING) }) {
                Text(text = "To Onboarding")
            }
        }
    }
}