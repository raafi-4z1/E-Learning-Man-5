package com.example.e_learningman5.core.domain.use_case.login

import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.core.data.remote.response.MyResponse
import com.example.e_learningman5.login.data.remote.LoginResponse
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    suspend fun getDataLogin(
        email: String,
        password: String
    ): Flow<MyResponse<ApiResponse<LoginResponse>>>

    /**
     *
     * Adakah Session yang tersimpan?
     *
     * -> Ada => true
     *
     * -> Tidak ada => false
     * */
    suspend fun getSession(): Boolean?
}