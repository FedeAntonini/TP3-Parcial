package com.example.tp3parcial.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.common.BaseTextField
import com.example.tp3parcial.common.FieldLabel

@Composable
fun DateOfBirthField(
    day: String,
    month: String,
    year: String,
    onDayChange: (String) -> Unit,
    onMonthChange: (String) -> Unit,
    onYearChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FieldLabel(text = "Date of birth")
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FieldLabel(text = "Day", color = MaterialTheme.colorScheme.tertiary)
                BaseTextField(value = day, onValueChange = onDayChange, placeholder = "08")
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FieldLabel(text = "Month", color = MaterialTheme.colorScheme.tertiary)
                BaseTextField(value = month, onValueChange = onMonthChange, placeholder = "12")
            }
            Column(
                modifier = Modifier.weight(2f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FieldLabel(text = "Year", color = MaterialTheme.colorScheme.tertiary)
                BaseTextField(value = year, onValueChange = onYearChange, placeholder = "1997")
            }
        }
    }
}