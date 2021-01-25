package com.app.spacez.data

sealed class ResultHolder<out T : Any?> {
    data class Success<out T : Any?>(val data: T?) : ResultHolder<T>()
    data class Error(val error: String?) : ResultHolder<Nothing>()
    data class Loading<out T : Any?>(val data: T? = null) : ResultHolder<T>()
}

fun <T : Any?> success(block: T?): ResultHolder<T> {
    return ResultHolder.Success(block)
}

fun error(block: String?): ResultHolder<Nothing> {
    return ResultHolder.Error(block)
}

fun <T : Any?> loading(): ResultHolder<T> {
    return ResultHolder.Loading()
}
