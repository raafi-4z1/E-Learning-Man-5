package com.example.e_learningman5.login.data.service

import android.content.SharedPreferences
import com.example.e_learningman5.core.data.services.login.LoginPreferencesHelper
import com.example.e_learningman5.core.util.Constants

class LoginPreferencesHelperImp(
    private val sharedPreferences: SharedPreferences
) : LoginPreferencesHelper {
    override suspend fun setLogin(nis: String, token: String) {
        sharedPreferences.edit().putString(Constants.NIS_PREFERENCES, nis).apply()
        sharedPreferences.edit().putString(Constants.TOKEN_PREFERENCES, token).apply()
    }

    override suspend fun getNis(): String? =
        sharedPreferences.getString(Constants.NIS_PREFERENCES, null)
}