package com.example.tp3parcial.common

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.tp3parcial.ui.theme.LinkColor

@Composable
fun LinkText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.labelLarge,
    fontWeight: FontWeight = FontWeight.Bold,
    fontSize: TextUnit = 14.sp
) {
    Text(
        text = text,
        textDecoration = TextDecoration.Underline,
        modifier = modifier.clickable(onClick = onClick),
        style = style,
        fontWeight = fontWeight,
        color = LinkColor,
        fontSize = fontSize
    )
}