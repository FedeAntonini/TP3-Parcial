package com.example.tp3parcial.api.notifications

data class NotificationsDto(
    val push: Boolean,
    val email: Boolean,
    val sms: Boolean
)