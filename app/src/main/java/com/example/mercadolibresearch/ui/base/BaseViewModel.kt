package com.example.mercadolibresearch.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mercadolibresearch.utils.Event
import io.reactivex.disposables.CompositeDisposable


open class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()
    protected val _isLoading = MutableLiveData<Event<Boolean>>()
    protected val _showError = MutableLiveData<Event<Boolean>>()

    val isLoading = _isLoading
    val showError = _showError
}