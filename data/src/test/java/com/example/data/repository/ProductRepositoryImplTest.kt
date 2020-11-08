package com.example.data.repository

import com.example.data.entity.DetailEntity
import com.example.data.getPorductResponseMocked
import com.example.data.getProductMocked
import com.example.data.source.SearchApi
import com.google.gson.GsonBuilder
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductRepositoryImplTest {
    companion object {
        private val PRODUCT_ID = "MLA876077268"
        private val productDetailsMocked = getProductMocked(PRODUCT_ID)
        private val productResponseMock = getPorductResponseMocked()
    }

    private var gson = GsonBuilder().create()

    @Mock
    private lateinit var searchApi: SearchApi
    private lateinit var productRepositoryImpl: ProductRepositoryImpl

    @Before
    fun setup() {
        productRepositoryImpl = ProductRepositoryImpl(searchApi)
    }

    @Test
    fun `it should return product response when when api call is successful`() {
        whenever(searchApi.getProductDetail(PRODUCT_ID)).thenReturn(
            Single.just(gson.fromJson(productResponseMock, DetailEntity::class.java))
        )
        val response =
            productRepositoryImpl.getProductsDetail(PRODUCT_ID).test().assertComplete().values()[0]
        Assert.assertEquals(productDetailsMocked, response)
    }

    @Test
    fun `it should get an Exception when api call is not successful`() {
        val error = Exception("Exception: No data received ")
        whenever(searchApi.getProductDetail(PRODUCT_ID)).thenReturn(
            Single.error(error)
        )
        val response =
            productRepositoryImpl.getProductsDetail(PRODUCT_ID).test().assertError(Exception::class.java)
        Assert.assertEquals("Exception: No data received ", response.errors()[0].message)
    }

}