package com.example.tp3parcial.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.common.BaseTextField

@Composable()
fun TelephoneField(
    countryCode: String,
    phoneNumber: String,
    onCountryCodeChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        BaseTextField(
            value = countryCode,
            onValueChange = onCountryCodeChange,
            placeholder = "+65",
            modifier = Modifier.width(88.dp)
        )

        BaseTextField(
            value = phoneNumber,
            onValueChange = onPhoneNumberChange,
            placeholder = "991251255",
            modifier = Modifier.weight(1f),
        )
    }
}

@Preview(showBackground = true)
@Composable()
fun TelephoneFieldPreview() {
    TelephoneField(
        countryCode = "+64",
        phoneNumber = "123123",
        onCountryCodeChange = {},
        onPhoneNumberChange = {},
    )
}