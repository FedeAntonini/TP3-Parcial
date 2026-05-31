package com.example.tp3parcial.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.tp3parcial.api.auth.models.AuthViewModel
import com.example.tp3parcial.onboarding.SplashScreen

@Composable
fun AppNavigation(authViewModel: AuthViewModel = hiltViewModel()) {
    val navController = rememberNavController()
    val isLoggedIn = authViewModel.isLoggedIn

    if (isLoggedIn == null) {
        SplashScreen(navController)
        return
    }

    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) Graph.HOME else Graph.AUTH,
    ) {
        authGraph(navController, authViewModel)
        homeGraph(navController, authViewModel)
    }
}