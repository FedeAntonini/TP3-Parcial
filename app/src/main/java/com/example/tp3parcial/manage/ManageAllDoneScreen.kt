package com.example.tp3parcial.manage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.common.BottomActionBar
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.common.RoundedCloseButton
import com.example.tp3parcial.manage.components.ManageAllDoneView
import com.example.tp3parcial.navigation.AppTopBar
import com.example.tp3parcial.navigation.Routes

@Composable
fun ManageAllDoneScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { RoundedCloseButton({ navController.navigate(Routes.MANAGE) }) },
                centerComponent = { Box(modifier = Modifier.offset(y = 18.dp)) { AppLogo(width = 116.52.dp) } },
            )
        },
        bottomBar = {
            BottomActionBar {
                PillButton(
                    text = "Done",
                    onClick = { navController.navigate(Routes.MANAGE) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) { padding ->
        ManageAllDoneView(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 24.dp)
        )
    }
}