package com.example.tp3parcial.api.product

import javax.inject.Inject
import javax.inject.Singleton

data class ProductsData(
    val featured: List<Product>,
    val categories: List<Category>,
    val brands: List<Brand>,
    val products: List<Product>
)

@Singleton
class ProductRepository @Inject constructor(
    private val api: ProductApi
) {
    suspend fun getProducts(): Result<ProductsData> = runCatching {
        val response = api.getProducts()
        ProductsData(
            featured = response.featured.map { it.toDomain() },
            categories = response.categories.map { Category(it.id, it.name, it.icon) },
            brands = response.brands.map { Brand(it.id, it.name, it.logo) },
            products = response.products.map { it.toDomain() }
        )
    }
}

