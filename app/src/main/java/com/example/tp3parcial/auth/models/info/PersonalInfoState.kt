package com.example.tp3parcial.auth.models.info

data class PersonalInfoState(
    val firstName: String = "",
    val lastName: String = "",
    val address: String = "",
    val city: String = "",
    val postalCode: String = "",
    val areaCode: String = "",
    val phoneNumber: String = "",
    val day: String = "",
    val month: String = "",
    val year: String = ""
)