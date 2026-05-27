package com.example.tp3parcial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp3parcial.auth.LoginScreen
import com.example.tp3parcial.auth.SmsVerificationScreen
import com.example.tp3parcial.auth.VerifyPhoneScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController    = navController,
        startDestination = Routes.HOME,
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(Routes.LOGIN_VERIFY){
            VerifyPhoneScreen(navController = navController)
        }
        composable(Routes.LOGIN_SMS) {
            SmsVerificationScreen(navController = navController, phoneNumber = "")
        }
        composable(Routes.HOME) {
            MainScreen(navController = navController)
        }
    }
}