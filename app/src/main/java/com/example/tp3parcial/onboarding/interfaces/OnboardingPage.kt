package com.example.tp3parcial.onboarding.interfaces

data class OnboardingPage(
    val image: Int,
    val title: String,
    val subtitle: String,
    val isLast: Boolean = false
)