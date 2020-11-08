package com.example.mercadolibresearch.model

import com.example.domain.model.Attribute
import com.example.domain.model.Pictures
import com.example.domain.model.ProductDetailResponse


class DetailProductModel (
    val id: String,
    val title: String,
    val price: Double,
    val originalPrice: Double?,
    val condition: String,
    val pictures: List<String>,
    val availableQuantity: Int,
    val soldQuantity: Int,
    val shippingTag: List<String>,
    val logisticType: String,
    val attribute: List<Attribute>,
    val warranty: String?,
    val health: Double?
) {
    companion object {
        fun convertTo(product: ProductDetailResponse): DetailProductModel =
            with(product) {
                DetailProductModel(
                    id,
                    title,
                    price,
                    originalPrice,
                    condition,
                    pictures.map { convertTo(it) },
                    availableQuantity,
                    soldQuantity,
                    shipping.tags,
                    shipping.logisticType,
                    attribute,
                    warranty,
                    health
                )
            }
        fun convertTo(pictures: Pictures): String {
            return pictures.url
        }
    }
}
