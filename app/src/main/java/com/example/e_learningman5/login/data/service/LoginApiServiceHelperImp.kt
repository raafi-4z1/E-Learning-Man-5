package com.example.e_learningman5.login.data.service

import com.example.e_learningman5.core.data.remote.AppApiService
import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.core.data.services.login.LoginApiServiceHelper
import com.example.e_learningman5.login.data.remote.LoginResponse
import retrofit2.Response

class LoginApiServiceHelperImp(private val service: AppApiService) : LoginApiServiceHelper {
    override suspend fun getDataLogin(
        email: String,
        password: String
    ): Response<ApiResponse<LoginResponse>> = service.getDataLogin(email, password)
}