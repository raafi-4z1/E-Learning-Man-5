package com.example.e_learningman5.main.data

import com.example.e_learningman5.core.data.remote.AppApiService
import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.core.data.services.main.MainApiServiceHelper
import com.example.e_learningman5.main.feature.profile.data.ProfileResponse
import retrofit2.Response

class MainApiServiceHelperImp(private val service: AppApiService) : MainApiServiceHelper {
    override suspend fun getDataProfile(token: String): Response<ApiResponse<ProfileResponse>> =
        service.getDataProfile(token)
}