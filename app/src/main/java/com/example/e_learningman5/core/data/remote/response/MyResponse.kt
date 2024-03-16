package com.example.e_learningman5.core.data.remote.response

sealed class MyResponse<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : MyResponse<T>(data)
    class Error<T>(message: String?, data: T? = null) : MyResponse<T>(data, message)
    class Loading<T> : MyResponse<T>()
}