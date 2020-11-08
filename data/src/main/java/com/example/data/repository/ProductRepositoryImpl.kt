package com.example.data.repository

import com.example.data.entity.DetailEntity.Companion.convertTo
import com.example.data.source.SearchApi
import com.example.domain.model.ProductDetailResponse
import com.example.domain.repository.ProductRespository
import io.reactivex.Single
import java.lang.Exception
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(private val searchApi: SearchApi) :
    ProductRespository {
    override fun getProductsDetail(id: String): Single<ProductDetailResponse> {
        return try {
            searchApi.getProductDetail(id).map {
                convertTo(it)
            }
        } catch (e: Exception) {
            Single.error(e)
        }
    }
}