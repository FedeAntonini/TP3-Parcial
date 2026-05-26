package com.example.tp3parcial.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label: String,
    val route: String,
    val icon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem("Home",    Routes.HOME,    Icons.Outlined.Home),
    BottomNavItem("Loan",    Routes.LOANS,   Icons.Outlined.List),
    BottomNavItem("Shop",    Routes.SHOP,    Icons.Outlined.Settings),
    BottomNavItem("History", Routes.HISTORY, Icons.Outlined.DateRange),
    BottomNavItem("Manage",  Routes.MANAGE,  Icons.Outlined.Person),
)