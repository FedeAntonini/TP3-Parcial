package com.example.tp3parcial.manage

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.common.BackButton
import com.example.tp3parcial.manage.components.ManageCreditScoreView
import com.example.tp3parcial.navigation.AppTopBar

@Composable
fun ManageCreditScoreScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { BackButton { } },
            )
        },
    ) { padding ->
        ManageCreditScoreView(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp),
            score = 720,
            scoreLabel = "Good",
            minScore = 300,
            maxScore = 850,
        )
    }
}

