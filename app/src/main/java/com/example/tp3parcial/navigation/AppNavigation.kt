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
import com.example.tp3parcial.debug.DebugScreen
import com.example.tp3parcial.history.HistoryScreen
import com.example.tp3parcial.history.TransactionDetailsScreen
import com.example.tp3parcial.home.CashInAmountScreen
import com.example.tp3parcial.home.CashInOptionsScreen
import com.example.tp3parcial.home.CashInSuccessScreen
import com.example.tp3parcial.home.DueDatesScreen
import com.example.tp3parcial.home.NotificationsScreen
import com.example.tp3parcial.home.OTCPartnersScreen
import com.example.tp3parcial.home.OnlineCashInScreen
import com.example.tp3parcial.loans.LoansActiveScreen
import com.example.tp3parcial.loans.LoansApplyScreen
import com.example.tp3parcial.loans.LoansSuccessScreen
import com.example.tp3parcial.manage.ManageAllDoneScreen
import com.example.tp3parcial.manage.ManageCreditScoreScreen
import com.example.tp3parcial.manage.ManageProfileDetailScreen
import com.example.tp3parcial.manage.ManageProfileScreen
import com.example.tp3parcial.onboarding.OnboardingScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
    ) {
        composable(Routes.LOGIN) {
            LoginScreen(navController = navController)
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
        composable(Routes.MANAGE_PAGE) {
            ManageProfileScreen(navController = navController)
        }
        composable(Routes.MANAGE_PROFILE) {
            ManageProfileDetailScreen(navController = navController)
        }
        composable(Routes.MANAGE_DONE) {
            ManageAllDoneScreen(navController = navController)
        }
        composable(Routes.MANAGE_CREDIT) {
            ManageCreditScoreScreen(navController = navController)
        }
        composable(Routes.HOME) {
            MainScreen(navController = navController)
        }
        composable(Routes.CASH_IN) {
            CashInOptionsScreen(navController = navController)
        }
        composable(Routes.CASH_IN_ONLINE) {
            OnlineCashInScreen(navController = navController)
        }
        composable(Routes.CASH_IN_OTC) {
            OTCPartnersScreen(navController = navController)
        }
        composable(Routes.CASH_IN_AMOUNT) {
            CashInAmountScreen(navController = navController)
        }
        composable(Routes.CASH_IN_SUCCESS) {
            CashInSuccessScreen(navController = navController)
        }
        composable(Routes.NOTIFICATIONS) {
            NotificationsScreen(navController = navController)
        }
        composable(Routes.DUE_DATES) {
            DueDatesScreen(navController = navController)
        }
        composable(Routes.LOANS_APPLY) {
            LoansApplyScreen(navController = navController)
        }
        composable(Routes.LOANS_SUCCESS) {
            LoansSuccessScreen(navController = navController)
        }
        composable(Routes.LOANS_ACTIVE) {
            LoansActiveScreen(navController = navController)
        }
        composable(Routes.HISTORY) {
            HistoryScreen(navController = navController)
        }
        composable(Routes.HISTORY_TRANSACTION) {
            TransactionDetailsScreen(navController = navController)
        }
        composable(Routes.ONBOARDING) {
            OnboardingScreen(navController = navController)
        }
        composable(Routes.DEBUG) {
            DebugScreen(navController = navController)
        }
    }
}