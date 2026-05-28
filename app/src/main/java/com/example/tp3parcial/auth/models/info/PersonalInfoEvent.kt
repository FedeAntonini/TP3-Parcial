package com.example.tp3parcial.auth.models.info

sealed class PersonalInfoEvent {
    data class FirstNameChanged(val value: String) : PersonalInfoEvent()
    data class LastNameChanged(val value: String) : PersonalInfoEvent()
    data class AddressChanged(val value: String) : PersonalInfoEvent()
    data class CityChanged(val value: String) : PersonalInfoEvent()
    data class PostalCodeChanged(val value: String) : PersonalInfoEvent()
    data class AreaCodeChanged(val value: String) : PersonalInfoEvent()
    data class PhoneNumberChanged(val value: String) : PersonalInfoEvent()
    data class DayChanged(val value: String) : PersonalInfoEvent()
    data class MonthChanged(val value: String) : PersonalInfoEvent()
    data class YearChanged(val value: String) : PersonalInfoEvent()
}