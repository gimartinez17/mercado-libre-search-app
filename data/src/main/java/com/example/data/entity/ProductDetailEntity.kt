package com.example.data.entity

import com.example.domain.model.Attribute
import com.example.domain.model.Pictures
import com.example.domain.model.ProductDetailResponse
import com.example.domain.model.ShippingDetails
import com.google.gson.annotations.SerializedName


data class DetailEntity(
    val id: String,
    val title: String,
    val price: Double,
    @SerializedName("original_price")
    val originalPrice: Double?,
    val condition: String,
    @SerializedName("available_quantity")
    val availableQuantity: Int,
    @SerializedName("sold_quantity")
    val soldQuantity: Int,
    val pictures: List<PicturesEntity>,
    val shipping: ShippingDetailsEntity,
    val attributes: List<AttributesEntity>,
    val warranty: String?,
    val health: Double?
) {
    companion object{
        fun convertTo(productEntity: DetailEntity): ProductDetailResponse =
            with(productEntity) {
                ProductDetailResponse(
                    id,
                    title,
                    price,
                    originalPrice,
                    condition,
                    pictures.map { convertTo(it) },
                    availableQuantity,
                    soldQuantity,
                    convertTo(shipping),
                    attributes.map { convertTo(it) },
                    warranty,
                    health
                )
            }
        fun convertTo(pictures: PicturesEntity): Pictures =
            Pictures(pictures.url)

        fun convertTo(shippingDetailsEntity: ShippingDetailsEntity): ShippingDetails =
            with(shippingDetailsEntity) {
                ShippingDetails(
                    tags,
                    logisticType
                )
            }
        fun convertTo(attributes: AttributesEntity): Attribute =
            with(attributes) {
                Attribute(
                    id,
                    name,
                    valueID,
                    valueName
                )
            }
    }
}

data class PicturesEntity(
    @SerializedName("secure_url")
    val url: String
)

data class ShippingDetailsEntity(
    val tags: List<String>,
    @SerializedName("logistic_type")
    val logisticType: String
)

data class AttributesEntity(
    val id: String,
    val name: String,
    @SerializedName("value_id")
    val valueID: String?,
    @SerializedName("value_name")
    val valueName: String?
)

