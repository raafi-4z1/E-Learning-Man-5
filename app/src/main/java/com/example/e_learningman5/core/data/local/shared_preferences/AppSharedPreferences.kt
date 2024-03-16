package com.example.e_learningman5.core.data.local.shared_preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.e_learningman5.core.utils.Constants

fun appSharedPreferences(androidApplication: Application): SharedPreferences =
    androidApplication.getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE)