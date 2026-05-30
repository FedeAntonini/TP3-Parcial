package com.example.tp3parcial.api.notifications

data class Notifications(
    val push: Boolean,
    val email: Boolean,
    val sms: Boolean
)