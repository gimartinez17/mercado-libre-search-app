package com.example.data.repository

import com.example.data.entity.SearchEntity.Companion.convertTo
import com.example.data.source.SearchApi
import com.example.domain.model.SearchResponse
import com.example.domain.repository.SearchRepository
import io.reactivex.Single
import java.lang.Exception
import javax.inject.Inject


class SearchRepositoryImpl @Inject constructor(private val searchApi: SearchApi) :
    SearchRepository {
    override fun getProductsByQuery(query: String): Single<SearchResponse> {
        return try {
            searchApi.getProductsByQuery(query).map {
                convertTo(it)
            }
        } catch (e: Exception) {
            Single.error(e)
        }
    }
}