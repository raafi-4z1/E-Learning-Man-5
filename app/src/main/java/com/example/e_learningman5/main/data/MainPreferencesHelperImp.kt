package com.example.e_learningman5.main.data

import android.content.SharedPreferences
import com.example.e_learningman5.core.data.services.main.MainPreferencesHelper
import com.example.e_learningman5.core.util.Constants

class MainPreferencesHelperImp(
    private val sharedPreferences: SharedPreferences
) : MainPreferencesHelper {
    override suspend fun getToken(): String? =
        sharedPreferences.getString(Constants.TOKEN_PREFERENCES, null)

    override suspend fun getNis(): String? =
        sharedPreferences.getString(Constants.NIS_PREFERENCES, null)
}