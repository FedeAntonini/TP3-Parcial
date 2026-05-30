package com.example.tp3parcial.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tp3parcial.auth.models.authentication.AuthViewModel
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

fun NavGraphBuilder.homeGraph(navController: NavController, authViewModel: AuthViewModel) {
    navigation(startDestination = Routes.HOME, route = Graph.HOME) {
        composable(Routes.MANAGE_PAGE) {
            ManageProfileScreen(navController = navController, authViewModel)
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
            MainScreen(navController = navController, authViewModel)
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
    }
}