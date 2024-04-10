package com.example.e_learningman5.login.data.service

import com.example.e_learningman5.core.data.local.db.AppDatabase
import com.example.e_learningman5.core.data.mappers.toStudentEntity
import com.example.e_learningman5.core.data.services.login.LoginDatabaseHelper
import com.example.e_learningman5.login.data.remote.LoginResponse
import java.time.LocalDateTime

class LoginDatabaseHelperImp(private val db: AppDatabase) : LoginDatabaseHelper {
    override suspend fun insertDataLogin(loginResponse: LoginResponse) {
        db.appDao().insert(loginResponse.toStudentEntity())
    }

    override suspend fun setSession(nis: String) {
        db.appDao().setSession(null, nis)
    }

    override suspend fun getSession(nis: String): LocalDateTime? = db.appDao().getSession(nis)
}