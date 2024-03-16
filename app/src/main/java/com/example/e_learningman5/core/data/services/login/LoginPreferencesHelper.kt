package com.example.e_learningman5.core.data.services.login

interface LoginPreferencesHelper {
    suspend fun setLogin(nis: String, token: String)
    suspend fun getNis(): String?
}