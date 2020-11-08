package com.example.data.repository

import com.example.data.entity.SearchEntity
import com.example.data.getSearchResultsMocked
import com.example.data.getSearchResponseMocked
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
class SearchRepositoryImplTest {

    companion object {
        private val QUERY_REQUEST = "dell"
        private val searchResultsMocked = getSearchResultsMocked(QUERY_REQUEST)
        private val searchResponseMock = getSearchResponseMocked()
    }

    private var gson = GsonBuilder().create()

    @Mock
    private lateinit var searchApi: SearchApi
    private lateinit var searchRepositoryImpl: SearchRepositoryImpl

    @Before
    fun setup() {
        searchRepositoryImpl = SearchRepositoryImpl(searchApi)
    }

    @Test
    fun `it should return search response when when api call is successful`() {
        whenever(searchApi.getProductsByQuery(QUERY_REQUEST)).thenReturn(
            Single.just(gson.fromJson(searchResponseMock, SearchEntity::class.java))
        )
        val response =
            searchRepositoryImpl.getProductsByQuery(QUERY_REQUEST).test().assertComplete().values()[0]
        Assert.assertEquals(searchResultsMocked.paging.total, response.paging.total)
        Assert.assertEquals(searchResultsMocked.query, response.query)
        Assert.assertEquals(searchResultsMocked.results[0], response.results[0])
    }

    @Test
    fun `it should get an Exception when api call is not successful`() {
        val error = Exception("Exception: No data received ")
        whenever(searchApi.getProductsByQuery(QUERY_REQUEST)).thenReturn(
            Single.error(error)
        )
        val response =
            searchRepositoryImpl.getProductsByQuery(QUERY_REQUEST).test().assertError(Exception::class.java)
        Assert.assertEquals("Exception: No data received ", response.errors()[0].message)
    }
}