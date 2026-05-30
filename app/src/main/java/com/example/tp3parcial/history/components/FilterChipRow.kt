package com.example.tp3parcial.history.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp3parcial.ui.theme.AppTheme


@Composable
fun FilterChipRow(filters: List<String>, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    var selected by remember { mutableStateOf("All") }

    Row(
        modifier = modifier.horizontalScroll(scrollState),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        filters.forEach { label ->
            val isSelected = selected == label
            FilterChip(
                selected = isSelected,
                onClick = { selected = label },
                shape = RoundedCornerShape(8.dp),
                label = {
                    Text(
                        text = label,
                        fontSize = 13.sp,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                        color = if (isSelected) Color.Black else MaterialTheme.colorScheme.primary,
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.secondary,
                    containerColor = Color.White,
                    selectedLabelColor = Color.White,
                    labelColor = MaterialTheme.colorScheme.primary,
                ),
                border = FilterChipDefaults.filterChipBorder(
                    enabled = true,
                    selected = isSelected,
                    borderColor = MaterialTheme.colorScheme.tertiary,
                    selectedBorderColor = Color.Transparent,
                    borderWidth = 1.dp,
                    selectedBorderWidth = 0.dp,
                ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterChipRowPreview() {
    AppTheme {
        val filters = listOf("All", "Type", "Balance", "Paid Bills", "Added")
        FilterChipRow(filters)
    }
}