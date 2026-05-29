package com.example.tp3parcial.manage

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.auth.components.ProfileDetailFormView
import com.example.tp3parcial.common.BackButton
import com.example.tp3parcial.common.BottomActionBar
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.navigation.AppTopBar

@Composable
fun ManageProfileDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { BackButton { } },
            )
        },
        bottomBar = {
            BottomActionBar {
                PillButton(
                    text = "Save",
                    onClick = { /* TODO login */ },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { padding ->
        ProfileDetailFormView(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp)
        )
    }
}