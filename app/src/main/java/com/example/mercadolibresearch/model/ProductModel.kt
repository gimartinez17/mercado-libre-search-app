package com.example.mercadolibresearch.model

import com.example.domain.model.Product


data class ProductModel(
    val id: String,
    val title: String,
    val price: Double,
    val thumbnail: String,
    val installmentQuantity: Int,
    val installmentRate: Double,
    val freeShipping: Boolean,
    val logisticType: String,
    val tags: List<String>?,
    val originalPrice: Double?
) {
    fun isFulfillment(): Boolean = logisticType == "fulfillment"

    fun isDealOfTheDay(): Boolean {
        if (tags != null && tags.contains("deal_of_the_day"))
            return true
        return false
    }

    fun isBestSeller(): Boolean {
        if (tags != null && tags.contains("best_seller_candidate"))
            return true
        return false
    }

    companion object {
        fun convertTo(product: Product): ProductModel =
            with(product) {
                ProductModel(
                    id,
                    title,
                    price,
                    thumbnail,
                    installments.quantity,
                    installments.rate,
                    shipping.freeShipping,
                    shipping.logisticType,
                    tags,
                    originalPrice
                )
            }

    }
}