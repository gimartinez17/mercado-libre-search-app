package com.example.domain.usecase

import com.example.domain.repository.ProductRespository
import javax.inject.Inject


class ProductUseCase @Inject constructor(private val productRepository: ProductRespository) {

    fun getProductDetails(id: String) = productRepository.getProductsDetail(id)

}