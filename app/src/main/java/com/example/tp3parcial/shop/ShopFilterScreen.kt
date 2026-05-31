package com.example.tp3parcial.shop

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tp3parcial.common.PillButton
import com.example.tp3parcial.ui.theme.InteractiveAccent
import com.example.tp3parcial.ui.theme.InteractivePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopFilterScreen(navController: NavController) {
    var selectedBrand by remember { mutableStateOf("All") }
    var selectedGender by remember { mutableStateOf("All") }
    var selectedSort by remember { mutableStateOf("Most Recent") }
    var selectedPrice by remember { mutableStateOf("All") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Filter", fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        selectedBrand = "All"
                        selectedGender = "All"
                        selectedSort = "Most Recent"
                        selectedPrice = "All"
                    },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("Reset Filter")
                }
                PillButton(
                    text = "Apply",
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Spacer(modifier = Modifier.height(4.dp))

            FilterSection(title = "Brands") {
                FilterChipGroup(
                    options = listOf("All", "Nike", "Adidas", "Puma", "Jordan"),
                    selected = selectedBrand,
                    onSelect = { selectedBrand = it }
                )
            }

            FilterSection(title = "Gender") {
                FilterChipGroup(
                    options = listOf("All", "Men", "Women"),
                    selected = selectedGender,
                    onSelect = { selectedGender = it }
                )
            }

            FilterSection(title = "Sort by") {
                FilterChipGroup(
                    options = listOf("Most Recent", "Popular", "Low Interest"),
                    selected = selectedSort,
                    onSelect = { selectedSort = it }
                )
            }

            FilterSection(title = "Price Range") {
                FilterChipGroup(
                    options = listOf("All", "\$500 - \$1000", "\$1000 - \$5000"),
                    selected = selectedPrice,
                    onSelect = { selectedPrice = it }
                )
            }
        }
    }
}

@Composable
fun FilterSection(title: String, content: @Composable () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold
        )
        content()
    }
}

@Composable
fun FilterChipGroup(
    options: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        options.forEach { option ->
            val isSelected = option == selected
            Surface(
                onClick = { onSelect(option) },
                shape = RoundedCornerShape(50),
                color = if (isSelected) InteractiveAccent
                else MaterialTheme.colorScheme.surfaceVariant,
            ) {
                Text(
                    text = option,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) InteractivePrimary
                    else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

