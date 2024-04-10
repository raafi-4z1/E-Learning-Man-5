package com.example.e_learningman5.main.domain

import com.example.e_learningman5.core.data.local.db.entities.StudentEntity
import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.core.data.remote.response.MyResponse
import com.example.e_learningman5.core.data.services.main.MainApiServiceHelper
import com.example.e_learningman5.core.data.services.main.MainDatabaseHelper
import com.example.e_learningman5.core.data.services.main.MainPreferencesHelper
import com.example.e_learningman5.core.domain.repository.main.MainRepository
import com.example.e_learningman5.main.feature.profile.data.ProfileResponse
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val mainPreferencesHelper: MainPreferencesHelper,
    private val mainApiServiceHelper: MainApiServiceHelper,
    private val mainDatabaseHelper: MainDatabaseHelper
) : MainRepository {
    override suspend fun getDataProfileRemote(token: String): Flow<MyResponse<ApiResponse<ProfileResponse>>> {
        TODO("Not yet implemented")
    }

    override suspend fun setDataProfileLocal(profileResponse: ProfileResponse) {
        TODO("Not yet implemented")
    }

    override suspend fun getDataProfileLocal(): Flow<MyResponse<StudentEntity>> {
        TODO("Not yet implemented")
    }
}