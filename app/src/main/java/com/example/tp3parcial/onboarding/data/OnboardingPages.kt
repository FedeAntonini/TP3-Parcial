package com.example.tp3parcial.onboarding.data

import com.example.tp3parcial.R
import com.example.tp3parcial.onboarding.interfaces.OnboardingPage

val onboardingPages = listOf(
    OnboardingPage(
        image = R.drawable.onboarding_1,
        title = "QUICK LOANS",
        subtitle = "Trusted for easy, fast loan approvals."
    ),
    OnboardingPage(
        image = R.drawable.onboarding_2,
        title = "LOAN PRODUCT IN-APP",
        subtitle = "Many products to loan."
    ),
    OnboardingPage(
        image = R.drawable.onboarding_3,
        title = "TRACK & PAY EASILY",
        subtitle = "",
        isLast = true
    )
)