package com.example.e_learningman5.core.domain.repository.login

import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.core.data.remote.response.MyResponse
import com.example.e_learningman5.login.data.remote.LoginResponse
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

interface LoginRepository {
    suspend fun getDataLogin(
        email: String,
        password: String
    ): Flow<MyResponse<ApiResponse<LoginResponse>>>

    suspend fun setLogin(nis: String, token: String)
    suspend fun getNis(): String?
    suspend fun setSession(nis: String)
    suspend fun getSession(nis: String): LocalDateTime?
}