package com.example.e_learningman5.core.data.remote.response

data class ApiResponse<T>(
    val status:String,
    val code: Int,
    val data: T
)