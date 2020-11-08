package com.example.mercadolibresearch.di

import com.example.data.repository.ProductRepositoryImpl
import com.example.data.repository.SearchRepositoryImpl
import com.example.data.source.SearchApi
import com.example.domain.usecase.ProductUseCase
import com.example.domain.usecase.SearchUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(gson: Gson): Retrofit {
        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideSearchApi(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSearchRepository(searchApi: SearchApi): SearchRepositoryImpl {
        return SearchRepositoryImpl(searchApi)
    }

    @Singleton
    @Provides
    fun provideSearchUseCase(searchRepository: SearchRepositoryImpl): SearchUseCase {
        return SearchUseCase(searchRepository)
    }

    @Singleton
    @Provides
    fun provideProductRepositoryImpl(searchApi: SearchApi): ProductRepositoryImpl {
        return ProductRepositoryImpl(searchApi)
    }

    @Singleton
    @Provides
    fun provideProductUseCase(productRepositoryImpl: ProductRepositoryImpl): ProductUseCase {
        return ProductUseCase(productRepositoryImpl)
    }
}