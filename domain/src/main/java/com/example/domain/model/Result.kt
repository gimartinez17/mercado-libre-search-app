package com.example.domain.model

import android.support.annotation.NonNull
import com.example.domain.model.Status.*

data class Result <out T>(val status: Status, val data: T?, val message: String?) {

    companion object{
        fun <T> success(@NonNull data: T): Result<T> = Result(
            status = SUCCESS,
            data = data,
            message = null)
        fun <T> error(message: String, data: T?): Result<T> = Result(
            status = ERROR,
            data = data,
            message = message)
        fun <T> loading(data: T): Result<T> = Result(
            status = LOADING,
            data = data,
            message = null)
    }
}