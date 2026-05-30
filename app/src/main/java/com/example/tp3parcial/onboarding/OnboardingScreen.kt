package com.example.tp3parcial.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.navigation.AppTopBar
import com.example.tp3parcial.navigation.Routes
import com.example.tp3parcial.onboarding.components.OnboardingView
import com.example.tp3parcial.onboarding.data.onboardingPages

@Composable
fun OnboardingScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            AppTopBar(
                centerComponent = { Box(modifier = Modifier.offset(y = 12.dp)) { AppLogo(width = 60.dp) } },
            )
        }
    ) { padding ->
        OnboardingView(
            pages = onboardingPages,
            onLogin = { navController.navigate(Routes.LOGIN)},
            onSignUp = { navController.navigate(Routes.LOGIN_VERIFY)},
            modifier = Modifier
                .background(Color(0xFF002203))
                .padding(padding)
                .padding(horizontal = 24.dp)
        )
    }
}