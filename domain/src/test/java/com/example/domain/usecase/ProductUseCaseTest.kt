package com.example.domain.usecase

import com.example.domain.repository.ProductRespository
import com.nhaarman.mockitokotlin2.whenever
import getProductMocked
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductUseCaseTest {
    companion object {
        private val PRODUCT_ID = "MLA876077268"
        private val productDetailsMocked = getProductMocked(PRODUCT_ID)
    }

    @Mock
    private lateinit var repository: ProductRespository
    private lateinit var productUseCase: ProductUseCase

    @Before
    fun setup() {
        productUseCase = ProductUseCase(repository)
    }

    @Test
    fun `it should return search response`() {
        whenever(repository.getProductsDetail(PRODUCT_ID)).thenReturn(
            Single.just(productDetailsMocked)
        )
        val response =
            productUseCase.getProductDetails(PRODUCT_ID).test().assertComplete().values()[0]
        Assert.assertEquals(productDetailsMocked, response)
    }

    @Test
    fun `it should get an Exception`() {
        val error = Exception("Exception: No data received ")
        whenever(repository.getProductsDetail(PRODUCT_ID)).thenReturn(
            Single.error(error)
        )
        val response =
            repository.getProductsDetail(PRODUCT_ID).test().assertError(Exception::class.java)
        Assert.assertEquals("Exception: No data received ", response.errors()[0].message)
    }
}