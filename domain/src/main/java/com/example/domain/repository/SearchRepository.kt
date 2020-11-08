package com.example.domain.repository

import com.example.domain.model.SearchResponse
import io.reactivex.Single


interface SearchRepository {
    fun getProductsByQuery(query: String): Single<SearchResponse>
}