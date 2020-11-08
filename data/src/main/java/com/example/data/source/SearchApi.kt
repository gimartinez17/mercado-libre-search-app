package com.example.data.source

import com.example.data.entity.DetailEntity
import com.example.data.entity.SearchEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface SearchApi {

    @GET("sites/MLA/search")
    fun getProductsByQuery(@Query("q") query: String,
//        @Query("offset") offset: Int,
//        @Query("limit") limit: Int
    ): Single<SearchEntity>

    @GET("/items/{id}")
    fun getProductDetail(@Path("id") id: String): Single<DetailEntity>
}