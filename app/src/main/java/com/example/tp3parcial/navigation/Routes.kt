package com.example.tp3parcial.navigation

object Routes {
    // Login
    const val LOGIN            = "login"
    const val LOGIN_VERIFY     = "login_verify"
    const val LOGIN_SMS        = "login_sms"
    const val LOGIN_FACE       = "login_face"
    const val LOGIN_ID         = "login_id"
    const val LOGIN_VERIFIED   = "login_verified"
    const val LOGIN_PROFILE    = "login_profile"
    const val LOGIN_SIGNATURE  = "login_signature"
    const val LOGIN_PASSWORD   = "login_password"
    const val LOGIN_DONE       = "login_done"

    // Main
    const val SPLASH   = "splash"
    const val HOME     = "home"
    const val LOANS    = "loans"
    const val SHOP     = "shop"
    const val HISTORY  = "history"
    const val MANAGE   = "manage"

    // Home flow
    const val CASH_IN         = "cash_in"
    const val CASH_IN_ONLINE  = "cash_in_online"
    const val CASH_IN_OTC     = "cash_in_otc"
    const val CASH_IN_AMOUNT  = "cash_in_amount"
    const val CASH_IN_SUCCESS = "cash_in_success"
    const val NOTIFICATIONS   = "notifications"
    const val DUE_DATES       = "due_dates"
}