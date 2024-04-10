package com.example.e_learningman5.core.data.services.main

import com.example.e_learningman5.core.data.local.db.entities.StudentEntity
import com.example.e_learningman5.main.feature.profile.data.ProfileResponse

interface MainDatabaseHelper {
    suspend fun insertDataProfile(profileResponse: ProfileResponse)
    suspend fun selectDataProfile(nis: String): StudentEntity
}