package com.example.tp3parcial.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.common.BaseTextField
import com.example.tp3parcial.common.FieldLabel
import com.example.tp3parcial.ui.theme.AppTheme

@Composable
fun VerifyPhoneView(
    modifier: Modifier = Modifier,
    countryCode: String,
    phoneNumber: String,
    onCountryCodeChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onSendCode: (countryCode: String, phoneNumber: String) -> Unit = { _, _ -> }
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {

        Text(
            text = "Verify your phone\nnumber with a code",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "We will send you a One-Time-Password (OTP) to confirm your number.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(28.dp))

        FieldLabel(text = "Your Phone Number")

        Spacer(modifier = Modifier.height(8.dp))

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
                placeholder = "Phone number",
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VerifyPhoneViewPreview() {
    var countryCode by remember { mutableStateOf("+65") }
    var phoneNumber by remember { mutableStateOf("") }

    AppTheme {
        VerifyPhoneView(
            countryCode = countryCode,
            phoneNumber = phoneNumber,
            onCountryCodeChange = { countryCode = it },
            onPhoneNumberChange = { phoneNumber = it }
        )
    }
}