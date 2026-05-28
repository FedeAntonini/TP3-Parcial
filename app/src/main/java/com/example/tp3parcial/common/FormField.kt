package com.example.tp3parcial.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FormField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FieldLabel(text = label)
        BaseTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = placeholder
        )
    }
}

@Preview(showBackground = true)
@Composable()
fun FormFieldPreview() {
    FormField(
        label = "Full legal last name",
        value = "Doe",
        onValueChange = {},
        placeholder = "Doe"
    )
}