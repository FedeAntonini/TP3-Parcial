package com.example.tp3parcial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp3parcial.auth.CreatePasswordPageScreen
import com.example.tp3parcial.auth.DonePageScreen
import com.example.tp3parcial.auth.FaceRecognitionScreen
import com.example.tp3parcial.auth.IdVerificationScreen
import com.example.tp3parcial.auth.LoginScreen
import com.example.tp3parcial.auth.ProfileDetailFormScreen
import com.example.tp3parcial.auth.SignaturePageScreen
import com.example.tp3parcial.auth.SmsVerificationScreen
import com.example.tp3parcial.auth.VerifiedScreen
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
        composable(Routes.LOGIN_FACE) {
            FaceRecognitionScreen(navController = navController)
        }
        composable(Routes.LOGIN_ID) {
            IdVerificationScreen(navController = navController)
        }
        composable(Routes.LOGIN_VERIFIED) {
            VerifiedScreen(navController = navController)
        }
        composable(Routes.LOGIN_PROFILE) {
            ProfileDetailFormScreen(navController = navController)
        }
        composable(Routes.LOGIN_SIGNATURE) {
            SignaturePageScreen(navController = navController)
        }
        composable(Routes.LOGIN_PASSWORD) {
            CreatePasswordPageScreen(navController = navController)
        }
        composable(Routes.LOGIN_DONE) {
            DonePageScreen(navController = navController)
        }
        composable(Routes.HOME) {
            MainScreen(navController = navController)
        }
    }
}