package com.example.domain.usecase

import com.example.domain.repository.SearchRepository
import javax.inject.Inject


class SearchUseCase @Inject constructor(private val searchRepository: SearchRepository) {

    fun getProductsByQuery(query: String) = searchRepository.getProductsByQuery(query)

}