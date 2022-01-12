package dev.eighteentech.tala.entities

sealed class Response<out T> {
    object Uninitialized : Response<Nothing>()
    object Loading : Response<Nothing>()
    data class Success<T>(val data: T) : Response<T>()
    data class Error(val error: Exception) : Response<Nothing>()
}