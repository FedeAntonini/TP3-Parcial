package com.example.tp3parcial.manage.interfaces


data class ProfileMenuItem(
    val icon: Int,
    val label: String,
    val onClick: () -> Unit
)