package com.example.tp3parcial.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tp3parcial.common.AppLogo
import com.example.tp3parcial.navigation.Routes
import com.example.tp3parcial.ui.theme.InteractiveAccent

// ── Data ──────────────────────────────────────────────────────────────────────
data class ShopProduct(
    val id: Int,
    val name: String,
    val price: String,
    val category: String
)

data class ShopCategory(val name: String, val icon: String)

val sampleCategories = listOf(
    ShopCategory("Phone", "📱"),
    ShopCategory("Headphones", "🎧"),
    ShopCategory("Apparel", "👕"),
    ShopCategory("More", "➕"),
)

val sampleBrands = listOf("Apple", "Jordan", "Adidas")

val sampleProducts = listOf(
    ShopProduct(1, "iPhone 12 Pro", "₱1,200 × 24 mo", "Phone"),
    ShopProduct(2, "iPhone 12 Pro", "₱1,200 × 24 mo", "Phone"),
    ShopProduct(3, "iPhone 12 Pro", "₱1,200 × 24 mo", "Phone"),
    ShopProduct(4, "Surface Laptop", "₱1,200 × 24 mo", "Laptop"),
    ShopProduct(5, "iPhone 12 Pro", "₱1,200 × 24 mo", "Phone"),
    ShopProduct(6, "PS4 Play Station", "₱1,200 × 24 mo", "Gaming"),
)

// ── Screen ────────────────────────────────────────────────────────────────────
@Composable
fun ShopScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item { ShopTopBar(navController) }
        item { ShopSearchBar(query = searchQuery, onQueryChange = { searchQuery = it }, navController) }
        item { Spacer(modifier = Modifier.height(16.dp)) }
        item { ShopBannerCard() }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item { ShopCategoriesSection() }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item { ShopBrandsSection() }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            ShopProductsSection(
                title = "Recommended For You",
                products = sampleProducts.take(3),
                navController = navController
            )
        }
        item { Spacer(modifier = Modifier.height(24.dp)) }
        item {
            ShopProductsSection(
                title = "Best Sellers",
                products = sampleProducts.drop(3),
                navController = navController
            )
        }
    }
}

// ── Top Bar ───────────────────────────────────────────────────────────────────
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopTopBar(navController: NavController) {
    TopAppBar(
        title = { AppLogo(width = 80.dp) },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Person, contentDescription = "Profile")
            }
        },
        actions = {
            IconButton(onClick = { navController.navigate(Routes.NOTIFICATIONS) }) {
                Icon(Icons.Outlined.Notifications, contentDescription = "Notifications")
            }
        }
    )
}

// ── Search Bar ────────────────────────────────────────────────────────────────
@Composable
fun ShopSearchBar(query: String, onQueryChange: (String) -> Unit, navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.weight(1f)) {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                placeholder = { Text("Search for product") },
                leadingIcon = { Icon(Icons.Outlined.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
                enabled = false
            )
            // Capa transparente encima que captura el toque
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .clickable { navController.navigate(Routes.SHOP_SEARCH) }
            )
        }
        IconButton(
            onClick = { navController.navigate(Routes.SHOP_FILTER) },
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Icon(Icons.Outlined.Tune, contentDescription = "Filter")
        }
    }
}

// ── Banner ────────────────────────────────────────────────────────────────────
@Composable
fun ShopBannerCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(20.dp)
    ) {
        Column {
            Text(
                text = "The New Shoes",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Shop this season's Top Silhouette",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
            Surface(
                shape = RoundedCornerShape(50),
                color = InteractiveAccent
            ) {
                Text(
                    text = "Shop Now",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

// ── Categories ────────────────────────────────────────────────────────────────
@Composable
fun ShopCategoriesSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        ShopSectionHeader(title = "Shop By Category")
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(sampleCategories) { category ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(category.icon, fontSize = 24.sp)
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = category.name,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}

// ── Brands ────────────────────────────────────────────────────────────────────
@Composable
fun ShopBrandsSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        ShopSectionHeader(title = "Popular Brands")
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(sampleBrands) { brand ->
                Box(
                    modifier = Modifier
                        .size(width = 80.dp, height = 56.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = brand,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

// ── Products Section ──────────────────────────────────────────────────────────
@Composable
fun ShopProductsSection(
    title: String,
    products: List<ShopProduct>,
    navController: NavController
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        ShopSectionHeader(title = title)
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(products) { product ->
                ShopProductCard(product = product, onClick = {
                    navController.navigate(Routes.SHOP_PRODUCT)
                })
            }
        }
    }
}

@Composable
fun ShopProductCard(product: ShopProduct, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center
        ) {
            Text("📱", fontSize = 32.sp)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = product.name,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
        )
        Text(
            text = product.price,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// ── Sección Header ────────────────────────────────────────────────────────────
@Composable
fun ShopSectionHeader(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        TextButton(onClick = {}) {
            Text(
                text = "See All →",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}