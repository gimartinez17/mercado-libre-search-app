package com.example.domain.model

data class SearchResponse(
    val query: String?,
    val paging: Paging,
    val results: List<Product>
)

data class Paging(
    val total: Int,
    val offset: Int,
    val limit: Int
)

data class Product(
    val id: String,
    val title: String,
    val price: Double,
    val thumbnail: String,
    val installments: Installments,
    val shipping: Shipping,
    val tags: List<String>?,
    val originalPrice: Double?
)

data class Installments(
    val quantity: Int,
    val rate: Double
)

data class Shipping(
    val freeShipping: Boolean,
    val logisticType: String
)
