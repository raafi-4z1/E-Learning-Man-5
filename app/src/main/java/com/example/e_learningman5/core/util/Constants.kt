package com.example.e_learningman5.core.util

import com.example.e_learningman5.BuildConfig

class Constants {
    companion object {
        internal const val BASE_URL = BuildConfig.BASE_URL
        internal const val IMAGE_BASE_URL = BuildConfig.IMAGE_BASE_URL
        internal const val DATABASE_NAME: String = "man5_database"

        internal const val SHARED_PREFERENCES: String = BuildConfig.prefName
        internal const val PREF_PASSWORD: String = BuildConfig.prefPassword
        internal const val NIS_PREFERENCES = "nisParam"
        internal const val TOKEN_PREFERENCES = "tokenParam"
    }
}