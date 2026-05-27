package com.example.tp3parcial.auth.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.common.FieldLabel
import com.example.tp3parcial.common.LinkText

private const val CODE_LENGTH = 6

private fun maskPhoneNumber(phone: String): String {
    if (phone.length <= 3) return phone
    val asterisks = "*".repeat(phone.length - 3)
    return asterisks + phone.takeLast(3)
}

@Composable
fun SmsVerificationView(
    modifier: Modifier = Modifier,
    phoneNumber: String,
    code: String,
    onCodeChange: (String) -> Unit,
    onResendCode: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 32.dp),
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        Text(
            text = "Enter the code",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Enter the security code we sent to ${maskPhoneNumber(phoneNumber)}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(28.dp))

        FieldLabel(text = "Your Phone Number")

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = code,
            onValueChange = { if (it.length <= CODE_LENGTH) onCodeChange(it) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            modifier = Modifier.fillMaxWidth(),
            decorationBox = {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    repeat(CODE_LENGTH) { index ->
                        val char = code.getOrNull(index)?.toString() ?: ""
                        val isFocused = index == code.length

                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .border(
                                    width = 1.5.dp,
                                    color = if (isFocused)
                                        MaterialTheme.colorScheme.tertiary
                                    else
                                        MaterialTheme.colorScheme.outline,
                                    shape = RoundedCornerShape(12.dp)
                                )
                        ) {
                            Text(
                                text = char,
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.tertiary,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            LinkText(
                text = "Didn't receive a code?",
                onClick = onResendCode
            )
        }
    }
}