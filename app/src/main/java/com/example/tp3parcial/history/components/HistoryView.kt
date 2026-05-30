package com.example.tp3parcial.history.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tp3parcial.common.CustomSearchBar
import com.example.tp3parcial.history.interfaces.HistorySection
import com.example.tp3parcial.history.interfaces.sampleHistorySections
import com.example.tp3parcial.ui.theme.AppTheme

@Composable
fun HistoryView(
    sections: List<HistorySection>,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    var searchQuery by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "History", style = MaterialTheme.typography.headlineMedium)

        CustomSearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            modifier = Modifier.fillMaxWidth()
        )

        FilterChipRow(
            modifier = Modifier
                .fillMaxWidth(),
            filters = listOf("All", "Type", "Balance", "Paid Bills", "Added")
        )
        HorizontalDivider(color = Color(0xFFE5E2E1))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            sections.forEach { section ->
                HistorySectionBlock(section = section)
                Spacer(modifier = Modifier.height(8.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun HistorySectionBlock(
    section: HistorySection,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text(
            text = section.title,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
        )
        HorizontalDivider(color = Color(0xFFE5E2E1))
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {

            section.items.forEachIndexed { index, item ->
                HistoryRow(
                    icon = item.type.iconRes,
                    label = item.type.label,
                    time = item.time,
                    company = item.company,
                    trailingText = item.amount,

                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HistoryViewPreview() {
    AppTheme {
        HistoryView(
            sections = sampleHistorySections,
            modifier = Modifier.fillMaxSize(),
        )
    }
}