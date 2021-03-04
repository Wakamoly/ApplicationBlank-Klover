package com.lucidsoftworksllc.applicationblank.others

sealed class DataState<out T : Any> {
    data class Success<out T : Any>(val data: T) : DataState<T>()
    data class Error(var message: String?, val statusCode: Int? = null) :
        DataState<Nothing>()
}
