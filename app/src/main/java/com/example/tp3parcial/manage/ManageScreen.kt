package com.example.tp3parcial.manage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.api.auth.models.AuthViewModel
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.common.RoundedNotificationButton
import com.example.tp3parcial.common.RoundedProfileButton
import com.example.tp3parcial.manage.components.ManageView
import com.example.tp3parcial.navigation.AppTopBar
import com.example.tp3parcial.navigation.Routes

@Composable
fun ManageScreen(navController: NavController, authViewModel: AuthViewModel) {
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { RoundedProfileButton(onClick = { navController.navigate(Routes.MANAGE_PROFILE) }) },
                centerComponent = { Box(modifier = Modifier.offset(y = 12.dp)) { AppLogo(width = 60.dp) } },
                rightComponent = { RoundedNotificationButton {} }
            )
        }
    ) { padding ->
        ManageView(
            onLogout = { authViewModel.logout() },
            onAccountDetails = { navController.navigate(Routes.MANAGE_PROFILE) },
            onCreditScore = { navController.navigate(Routes.MANAGE_CREDIT) },
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp)
        )
    }
}