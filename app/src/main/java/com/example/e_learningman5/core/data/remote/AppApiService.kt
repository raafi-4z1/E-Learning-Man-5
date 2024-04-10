package com.example.e_learningman5.core.data.remote

import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.login.data.remote.LoginResponse
import com.example.e_learningman5.main.feature.profile.data.ProfileResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface AppApiService {
    @FormUrlEncoded
    @POST("login")
    suspend fun getDataLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<ApiResponse<LoginResponse>>

    @POST("profile")
    suspend fun getDataProfile(
        @Header("Authorization") token: String,
    ): Response<ApiResponse<ProfileResponse>>
}