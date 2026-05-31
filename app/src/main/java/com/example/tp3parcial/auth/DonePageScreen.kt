package com.example.tp3parcial.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.auth.components.DonePageView
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.common.BottomActionBar
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.common.RoundedCloseButtonVariant
import com.example.tp3parcial.navigation.AppTopBar
import com.example.tp3parcial.navigation.Routes

@Composable
fun DonePageScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { RoundedCloseButtonVariant(onClick = { navController.popBackStack() }) },
                centerComponent = { Box(modifier = Modifier.offset(y = 24.dp)) { AppLogo(width = 116.52.dp) } },
            )
        },
        bottomBar = {
            BottomActionBar {
                PillButton(
                    text = "Done",
                    onClick = { navController.navigate(Routes.LOGIN) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { padding ->
        DonePageView(
            modifier = Modifier
                .background(color = Color(0xFF002203))
                .padding(padding)
                .padding(horizontal = 24.dp)
        )
    }
}