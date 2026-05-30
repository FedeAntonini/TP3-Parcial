package com.example.tp3parcial.manage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.auth.models.authentication.AuthViewModel
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.common.RoundedNotificationButton
import com.example.tp3parcial.common.RoundedProfileButton
import com.example.tp3parcial.manage.components.ManageProfileView
import com.example.tp3parcial.navigation.AppTopBar

@Composable
fun ManageProfileScreen(navController: NavController, authViewModel: AuthViewModel) {
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { RoundedProfileButton {} },
                centerComponent = { Box(modifier = Modifier.offset(y = 12.dp)) { AppLogo(width = 60.dp) } },
                rightComponent = { RoundedNotificationButton {} }
            )
        }
    ) { padding ->
        ManageProfileView(
            onLogout = { authViewModel.logout() },
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp)
        )
    }
}