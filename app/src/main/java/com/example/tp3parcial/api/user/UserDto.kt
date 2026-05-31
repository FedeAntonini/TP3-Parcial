package com.example.tp3parcial.api.user

import com.example.tp3parcial.api.notifications.Notifications
import com.example.tp3parcial.api.notifications.NotificationsDto
import java.time.LocalDate

data class UserResponseDto(
    val success: Boolean,
    val user: UserDto
)
data class UserDto(
    val id: Int,
    val fullName: String,
    val phone: String,
    val email: String,
    val avatar: String,
    val birthDate: String,
    val address: String,
    val creditScore: Int,
    val creditLevel: String,
    val availableBalance: Int,
    val totalLoanLimit: Int,
    val memberSince: String,
    val isVerified: Boolean,
    val notifications: NotificationsDto
)

fun UserDto.toDomain() = User(
    id = id,
    fullName = fullName,
    phone = phone,
    email = email,
    avatar = avatar,
    birthDate = LocalDate.parse(birthDate),
    address = address,
    creditScore = creditScore,
    creditLevel = creditLevel,
    availableBalance = availableBalance,
    totalLoanLimit = totalLoanLimit,
    memberSince = LocalDate.parse(memberSince),
    isVerified = isVerified,
    notifications = Notifications(
        push = notifications.push,
        email = notifications.email,
        sms = notifications.sms
    )
)

