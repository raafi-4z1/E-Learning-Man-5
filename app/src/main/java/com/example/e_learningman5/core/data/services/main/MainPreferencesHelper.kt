package com.example.e_learningman5.core.data.services.main

interface MainPreferencesHelper {
    suspend fun getToken(): String?
    suspend fun getNis(): String?
}