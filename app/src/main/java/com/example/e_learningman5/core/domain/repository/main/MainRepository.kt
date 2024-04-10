package com.example.e_learningman5.core.domain.repository.main

import com.example.e_learningman5.core.data.local.db.entities.StudentEntity
import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.core.data.remote.response.MyResponse
import com.example.e_learningman5.main.feature.profile.data.ProfileResponse
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    suspend fun getDataProfileRemote(token: String): Flow<MyResponse<ApiResponse<ProfileResponse>>>
    suspend fun setDataProfileLocal(profileResponse: ProfileResponse)
    suspend fun getDataProfileLocal(): Flow<MyResponse<StudentEntity>>
}