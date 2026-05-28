package com.example.tp3parcial.auth.models.info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonalInfoViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(PersonalInfoState())
        private set

    fun onEvent(event: PersonalInfoEvent) {
        state = when (event) {
            is PersonalInfoEvent.FirstNameChanged -> state.copy(firstName = event.value)
            is PersonalInfoEvent.LastNameChanged -> state.copy(lastName = event.value)
            is PersonalInfoEvent.AddressChanged -> state.copy(address = event.value)
            is PersonalInfoEvent.CityChanged -> state.copy(city = event.value)
            is PersonalInfoEvent.PostalCodeChanged -> state.copy(postalCode = event.value)
            is PersonalInfoEvent.AreaCodeChanged -> state.copy(areaCode = event.value)
            is PersonalInfoEvent.PhoneNumberChanged -> state.copy(phoneNumber = event.value)
            is PersonalInfoEvent.DayChanged -> state.copy(day = event.value)
            is PersonalInfoEvent.MonthChanged -> state.copy(month = event.value)
            is PersonalInfoEvent.YearChanged -> state.copy(year = event.value)
        }
    }
}