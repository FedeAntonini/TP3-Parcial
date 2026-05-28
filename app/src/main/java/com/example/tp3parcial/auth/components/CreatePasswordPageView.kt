package com.example.tp3parcial.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.common.FieldLabel
import com.example.tp3parcial.ui.theme.AppTheme

@Composable
fun CreatePasswordPageView(
    modifier: Modifier = Modifier,
    password: String,
    onPasswordChange: (String) -> Unit,
) {
    Column(modifier = modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.spacedBy(32.dp)) {
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    text = "Create your password",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    FieldLabel(text = "Choose a password")
                    PasswordField(value = password, onValueChange = onPasswordChange)
                }
                Text(
                    text = buildAnnotatedString {
                        append("At least ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("9 characters")
                        }
                        append(", containing ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("a letter")
                        }
                        append(" and ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("a number")
                        }
                    },
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CreatePasswordPageViewPreview() {
    AppTheme {
        CreatePasswordPageView(
            password = "123456",
            onPasswordChange = {}
        )
    }
}