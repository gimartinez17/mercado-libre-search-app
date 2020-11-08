package com.example.domain.usecase

import com.example.domain.repository.SearchRepository
import com.nhaarman.mockitokotlin2.whenever
import getSearchResultsMocked
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchUseCaseTest {

    companion object {
        private val QUERY_REQUEST = "dell"
        private val searchResultsMocked = getSearchResultsMocked(QUERY_REQUEST)
    }

    @Mock
    private lateinit var repository: SearchRepository
    private lateinit var searchUseCase: SearchUseCase

    @Before
    fun setup() {
        searchUseCase = SearchUseCase(repository)
    }

    @Test
    fun `it should return search response`() {
        whenever(repository.getProductsByQuery(QUERY_REQUEST)).thenReturn(
            Single.just(searchResultsMocked)
        )
        val response = searchUseCase.getProductsByQuery(QUERY_REQUEST).test().assertComplete().values()[0]
        Assert.assertEquals(searchResultsMocked.paging.total, response.paging.total)
        Assert.assertEquals(searchResultsMocked.query, response.query)
        Assert.assertEquals(searchResultsMocked.results[0], response.results[0])
    }

    @Test
    fun `it should get an Exception`() {
        val error = Exception("Exception: No data received ")
        whenever(repository.getProductsByQuery(QUERY_REQUEST)).thenReturn(
            Single.error(error)
        )
        val response =
            repository.getProductsByQuery(QUERY_REQUEST).test().assertError(Exception::class.java)
        Assert.assertEquals("Exception: No data received ", response.errors()[0].message)
    }
}