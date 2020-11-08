package com.example.mercadolibresearch.ui.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.model.ProductDetailResponse
import com.example.domain.usecase.ProductUseCase
import com.example.mercadolibresearch.model.DetailProductModel
import com.example.mercadolibresearch.model.DetailProductModel.Companion.convertTo
import com.example.mercadolibresearch.ui.base.BaseViewModel
import com.example.mercadolibresearch.utils.Event
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class ProductViewModel @ViewModelInject constructor(private val productUseCase: ProductUseCase) :
    BaseViewModel() {

    private val _productDetail = MutableLiveData<DetailProductModel>()
    val productDetail: LiveData<DetailProductModel> = _productDetail

    fun getProductDetail(id: String) {
        _isLoading.value = Event(true)
        compositeDisposable.add(
            productUseCase.getProductDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onProductDetailReceived, this::onErrorReceived)
        )
    }

    private fun onProductDetailReceived(details: ProductDetailResponse) {
        _productDetail.value = convertTo(details)
        _isLoading.value = Event(false)
        _showError.value = Event(false)

    }

    private fun onErrorReceived(throwable: Throwable) {
        Log.e( SearchViewModel::class.simpleName,
            "Error while loading products data" + " " + throwable.message)
        _isLoading.value = Event(false)
        _showError.value = Event(true)
    }
}