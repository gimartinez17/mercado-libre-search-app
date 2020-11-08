package com.example.domain.model

data class ProductDetailResponse(
    val id: String,
    val title: String,
    val price: Double,
    val originalPrice: Double?,
    val condition: String,
    val pictures: List<Pictures>,
    val availableQuantity: Int,
    val soldQuantity: Int,
    val shipping: ShippingDetails,
    val attribute: List<Attribute>,
    val warranty: String?,
    val health: Double?
)

data class Pictures(
    val url: String
)

data class ShippingDetails(
    val tags: List<String>,
    val logisticType: String
)

data class Attribute(
    val id: String,
    val name: String,
    val valueID: String?,
    val valueName: String?
)