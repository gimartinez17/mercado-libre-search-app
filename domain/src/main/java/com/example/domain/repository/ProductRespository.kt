package com.example.domain.repository

import com.example.domain.model.ProductDetailResponse
import io.reactivex.Single


interface ProductRespository {
    fun getProductsDetail(id: String): Single<ProductDetailResponse>
}