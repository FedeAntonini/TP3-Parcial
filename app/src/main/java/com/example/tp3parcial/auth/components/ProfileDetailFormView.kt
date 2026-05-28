package com.example.tp3parcial.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.tp3parcial.auth.models.info.PersonalInfoEvent
import com.example.tp3parcial.auth.models.info.PersonalInfoViewModel
import com.example.tp3parcial.common.FieldLabel
import com.example.tp3parcial.common.FormField
import com.example.tp3parcial.ui.theme.AppTheme

@Composable
fun ProfileDetailFormView(
    modifier: Modifier = Modifier,
    viewModel: PersonalInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "Enter your personal\ndetails",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )
        FormField(
            label = "Full legal first and middle name(s)",
            value = state.firstName,
            onValueChange = { viewModel.onEvent(PersonalInfoEvent.FirstNameChanged(it)) },
            placeholder = "John D."
        )
        FormField(
            label = "Full legal last name",
            value = state.lastName,
            onValueChange = { viewModel.onEvent(PersonalInfoEvent.LastNameChanged(it)) },
            placeholder = "Doe"
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            DateOfBirthField(
                day = state.day,
                month = state.month,
                year = state.year,
                onDayChange = { viewModel.onEvent(PersonalInfoEvent.DayChanged(it)) },
                onMonthChange = { viewModel.onEvent(PersonalInfoEvent.MonthChanged(it)) },
                onYearChange = { viewModel.onEvent(PersonalInfoEvent.YearChanged(it)) }

            )
        }
        FormField(
            label = "Address",
            value = state.address,
            onValueChange = { viewModel.onEvent(PersonalInfoEvent.AddressChanged(it)) },
            placeholder = "Somewhere IN BLOCK 12"
        )
        FormField(
            label = "City",
            value = state.city,
            onValueChange = { viewModel.onEvent(PersonalInfoEvent.CityChanged(it)) },
            placeholder = "Davao City"
        )
        FormField(
            label = "Postal Code",
            value = state.postalCode,
            onValueChange = { viewModel.onEvent(PersonalInfoEvent.PostalCodeChanged(it)) },
            placeholder = "8000"
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            FieldLabel("Phone Number")
            TelephoneField(
                countryCode = state.areaCode,
                phoneNumber = state.phoneNumber,
                onCountryCodeChange = { viewModel.onEvent(PersonalInfoEvent.AreaCodeChanged(it)) },
                onPhoneNumberChange = { viewModel.onEvent(PersonalInfoEvent.PhoneNumberChanged(it)) }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfileDetailFormViewPreview() {
    AppTheme {
        ProfileDetailFormView()
    }
}