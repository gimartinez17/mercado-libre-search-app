package com.example.mercadolibresearch.ui.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.SearchResponse
import com.example.domain.usecase.SearchUseCase
import com.example.mercadolibresearch.ui.base.BaseViewModel
import com.example.mercadolibresearch.utils.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class SearchViewModel @ViewModelInject constructor(
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {

    private val _products = MutableLiveData<SearchResponse>()
    private val _showEmpty =  MutableLiveData<Event<Boolean>>()
    val products: LiveData<SearchResponse> = _products
    val showEmpty = _showEmpty

    private var _query: String = ""


    fun getProductsByQuery(query: String) {
        _showEmpty.value = Event(false)
        _isLoading.value = Event(true)
        _showError.value = Event(false)
        _query = query
        compositeDisposable.add(searchUseCase.getProductsByQuery(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onProductsReceived, this::onErrorReceived)
        )
    }

    private fun onProductsReceived(response: SearchResponse) {
        _isLoading.value = Event(false)
        _showError.value = Event(false)
        _products.value = response

    }

    private fun onErrorReceived(throwable: Throwable) {
        Log.e(SearchViewModel::class.simpleName, "Error while loading products data" + " " + throwable.message)
        _isLoading.value = Event(false)
        _showError.value = Event(true)
    }

    fun onClickRetryButton() {
        getProductsByQuery(_query)
    }
}