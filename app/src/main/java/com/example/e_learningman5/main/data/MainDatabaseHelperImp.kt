package com.example.e_learningman5.main.data

import com.example.e_learningman5.core.data.local.db.AppDatabase
import com.example.e_learningman5.core.data.local.db.entities.StudentEntity
import com.example.e_learningman5.core.data.mappers.toStudentEntity
import com.example.e_learningman5.core.data.services.main.MainDatabaseHelper
import com.example.e_learningman5.main.feature.profile.data.ProfileResponse

class MainDatabaseHelperImp(private val db: AppDatabase) : MainDatabaseHelper {
    override suspend fun insertDataProfile(profileResponse: ProfileResponse) {
        db.appDao().insert(profileResponse.toStudentEntity())
    }

    override suspend fun selectDataProfile(nis: String): StudentEntity =
        db.appDao().selectStudent(nis)
}