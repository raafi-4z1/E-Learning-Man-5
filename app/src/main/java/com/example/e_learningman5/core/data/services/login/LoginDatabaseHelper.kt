package com.example.e_learningman5.core.data.services.login

import com.example.e_learningman5.login.data.remote.LoginResponse
import java.time.LocalDateTime

interface LoginDatabaseHelper {
    suspend fun insertDataLogin(loginResponse: LoginResponse)
    suspend fun setSession(nis: String)
    suspend fun getSession(nis: String): LocalDateTime?
}