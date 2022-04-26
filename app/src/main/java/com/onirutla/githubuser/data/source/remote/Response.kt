package com.onirutla.githubuser.data.source.remote

sealed class Response<T> {
    data class Success<T>(val body: T, val message: String? = null) : Response<T>()
    data class Error<T>(val data: T? = null, val message: String? = null) : Response<T>()
}