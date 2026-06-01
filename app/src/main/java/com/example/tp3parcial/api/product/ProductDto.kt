package com.example.tp3parcial.api.product

data class ProductsResponseDto(
    val success: Boolean,
    val featured: List<ProductDto>,
    val categories: List<CategoryDto>,
    val brands: List<BrandDto>,
    val products: List<ProductDto>
)

data class ProductDto(
    val id: String,
    val name: String,
    val brand: String,
    val category: String,
    val price: Double,
    val currency: String,
    val image: String,
    val monthlyInstallment: Double,
    val installmentMonths: Int,
    val interestRate: Double,
    val isFeatured: Boolean,
    val isAvailable: Boolean,
    val rating: Double,
    val reviewCount: Int,
    val description: String? = null
)

data class CategoryDto(
    val id: String,
    val name: String,
    val icon: String,
    val productCount: Int
)

data class BrandDto(
    val id: String,
    val name: String,
    val logo: String
)

data class Product(
    val id: String,
    val name: String,
    val brand: String,
    val category: String,
    val price: Double,
    val currency: String,
    val image: String,
    val monthlyInstallment: Double,
    val installmentMonths: Int,
    val isFeatured: Boolean,
    val isAvailable: Boolean,
    val description: String?
)

data class Category(val id: String, val name: String, val icon: String)
data class Brand(val id: String, val name: String, val logo: String)

fun ProductDto.toDomain() = Product(
    id = id,
    name = name,
    brand = brand,
    category = category,
    price = price,
    currency = currency,
    image = image,
    monthlyInstallment = monthlyInstallment,
    installmentMonths = installmentMonths,
    isFeatured = isFeatured,
    isAvailable = isAvailable,
    description = description
)

