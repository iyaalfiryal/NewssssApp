package com.iyaliyul.newssssapp.utils

sealed class Resources<out R> {
    data class Success<out T>(val data: T): Resources<T>()
    data class Error<T>(val message: String, val data: T? = null): Resources<T>()
    object Empty: Resources<Nothing>()
    object Loading: Resources<Nothing>()
}