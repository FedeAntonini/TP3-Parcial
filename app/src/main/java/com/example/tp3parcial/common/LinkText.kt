package com.example.tp3parcial.common

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import com.example.tp3parcial.ui.theme.LinkColor

@Composable
fun LinkText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        textDecoration = TextDecoration.Underline,
        modifier = modifier.clickable(onClick = onClick),
        style = MaterialTheme.typography.labelLarge,
        color = LinkColor
    )
}