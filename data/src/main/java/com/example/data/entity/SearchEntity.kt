package com.example.data.entity

import com.example.domain.model.*
import com.google.gson.annotations.SerializedName


data class SearchEntity(
    val query: String?,
    val paging: PagingEntity,
    val results: List<ProductEntity>
) {
    companion object {

        fun convertTo(searchEntity: SearchEntity): SearchResponse =
            with(searchEntity) {
                SearchResponse(
                    query,
                    convertTo(paging),
                    results.map { convertTo(it) }
                )
            }

        fun convertTo(paging: PagingEntity): Paging =
            with(paging) {
                Paging(
                    total,
                    offset,
                    limit
                )
            }

        fun convertTo(productEntity: ProductEntity): Product =
            with(productEntity) {
                Product(
                    id,
                    title,
                    price,
                    thumbnail,
                    convertTo(installments),
                    convertTo(shipping),
                    tags,
                    originalPrice
                )
            }

        fun convertTo(installmentsEntity: InstallmentsEntity): Installments =
            Installments(installmentsEntity.quantity, installmentsEntity.rate)

        fun convertTo(shippingEntity: ShippingEntity): Shipping =
            Shipping(shippingEntity.freeShipping, shippingEntity.logisticType)
    }
}

data class ProductEntity(
    val id: String,
    val title: String,
    val price: Double,
    val thumbnail: String,
    val installments: InstallmentsEntity,
    val shipping: ShippingEntity,
    val tags: List<String>?,
    @SerializedName("original_price")
    val originalPrice: Double?
)

data class PagingEntity(
    val total: Int,
    val offset: Int,
    val limit: Int
)

data class InstallmentsEntity(
    val quantity: Int,
    val rate: Double
)

data class ShippingEntity(
    @SerializedName("free_shipping")
    val freeShipping: Boolean,
    @SerializedName("logistic_type")
    val logisticType: String
)