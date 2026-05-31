package com.example.tp3parcial.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tp3parcial.api.auth.models.AuthViewModel
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
import com.example.tp3parcial.manage.ManageProfileScreen
import com.example.tp3parcial.manage.ManageScreen
import com.example.tp3parcial.shop.ShopFilterScreen
import com.example.tp3parcial.shop.ShopProductDetailScreen
import com.example.tp3parcial.shop.ShopSearchScreen

fun NavGraphBuilder.homeGraph(navController: NavController, authViewModel: AuthViewModel) {
    navigation(startDestination = Routes.HOME, route = Graph.HOME) {
        composable(Routes.MANAGE) {
            ManageScreen(navController = navController, authViewModel)
        }
        composable(Routes.MANAGE_PROFILE) {
            ManageProfileScreen(navController = navController)
        }
        composable(Routes.MANAGE_DONE) {
            ManageAllDoneScreen(navController = navController)
        }
        composable(Routes.MANAGE_CREDIT) {
            ManageCreditScoreScreen(navController = navController, authViewModel)
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
        composable(Routes.SHOP_PRODUCT) {
            ShopProductDetailScreen(navController = navController)
        }
        composable(Routes.SHOP_SEARCH) {
            ShopSearchScreen(navController = navController)
        }
        composable(Routes.SHOP_FILTER) {
            ShopFilterScreen(navController = navController)
        }
    }
}