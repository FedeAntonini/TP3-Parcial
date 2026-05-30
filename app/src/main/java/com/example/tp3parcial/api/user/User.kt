package com.example.tp3parcial.api.user

import com.example.tp3parcial.api.notifications.Notifications
import java.time.LocalDate

data class User(
    val id: Int,
    val fullName: String,
    val phone: String,
    val email: String,
    val avatar: String,
    val birthDate: LocalDate,
    val address: String,
    val creditScore: Int,
    val creditLevel: String,
    val availableBalance: Int,
    val totalLoanLimit: Int,
    val memberSince: LocalDate,
    val isVerified: Boolean,
    val notifications: Notifications
)
