package com.example.e_learningman5.core.data.services.login

import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.login.data.remote.LoginResponse
import retrofit2.Response

interface LoginApiServiceHelper {
    suspend fun getDataLogin(email: String, password: String): Response<ApiResponse<LoginResponse>>
}