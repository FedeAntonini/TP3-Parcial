package com.example.tp3parcial.auth


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
import com.example.tp3parcial.common.RoundedInfoButton
import com.example.tp3parcial.navigation.AppTopBar
import com.example.tp3parcial.navigation.Routes


@Composable
fun ProfileDetailFormScreen(navController: NavController) {
    Scaffold(
        topBar = {
            AppTopBar(
                leftComponent = { BackButton({ navController.popBackStack() })  },
                rightComponent = { RoundedInfoButton {} }
            )
        },
        bottomBar = {
            BottomActionBar {
                PillButton(
                    text = "Next",
                    onClick = { navController.navigate(Routes.LOGIN_SIGNATURE) },
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