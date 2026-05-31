package com.example.tp3parcial.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tp3parcial.api.auth.models.AuthViewModel
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
import com.example.tp3parcial.debug.DebugScreen
import com.example.tp3parcial.onboarding.OnboardingScreen

fun NavGraphBuilder.authGraph(navController: NavController, authViewModel: AuthViewModel) {
    navigation(startDestination = Routes.ONBOARDING, route = Graph.AUTH) {
        composable(Routes.LOGIN) {
            LoginScreen(navController, authViewModel)
        }
        composable(Routes.LOGIN_VERIFY) {
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
        composable(Routes.ONBOARDING) {
            OnboardingScreen(navController = navController)
        }
        composable(Routes.DEBUG) {
            DebugScreen(navController = navController)
        }
    }
}