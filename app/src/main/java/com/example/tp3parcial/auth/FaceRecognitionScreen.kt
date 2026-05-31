package com.example.tp3parcial.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.auth.components.FaceRecognitionView
import com.example.tp3parcial.common.BackButton
import com.example.tp3parcial.common.BottomActionBar
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.common.RoundedInfoButton
import com.example.tp3parcial.navigation.AppTopBar
import com.example.tp3parcial.navigation.Routes


@Composable
fun FaceRecognitionScreen(navController: NavController) {
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
                    text = "Next",
                    onClick = { navController.navigate(Routes.LOGIN_ID) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { padding ->
        FaceRecognitionView(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp)
        )
    }
}