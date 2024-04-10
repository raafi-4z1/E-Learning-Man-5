package com.example.e_learningman5.core.data.services.main

import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.main.feature.profile.data.ProfileResponse
import retrofit2.Response

interface MainApiServiceHelper {
    suspend fun getDataProfile(token: String): Response<ApiResponse<ProfileResponse>>
}