package com.example.e_learningman5.core.di

import android.content.SharedPreferences
import com.example.e_learningman5.core.data.local.db.AppDatabase
import com.example.e_learningman5.core.data.local.shared_preferences.appSharedPreferences
import com.example.e_learningman5.core.data.services.login.LoginApiServiceHelper
import com.example.e_learningman5.core.data.services.login.LoginDatabaseHelper
import com.example.e_learningman5.core.data.services.login.LoginPreferencesHelper
import com.example.e_learningman5.core.domain.repository.login.LoginRepository
import com.example.e_learningman5.core.domain.use_case.login.LoginUseCase
import com.example.e_learningman5.core.utils.Constants
import com.example.e_learningman5.login.data.service.LoginApiServiceHelperImp
import com.example.e_learningman5.login.data.service.LoginDatabaseHelperImp
import com.example.e_learningman5.login.data.service.LoginPreferencesHelperImp
import com.example.e_learningman5.login.domain.repository.LoginRepositoryImpl
import com.example.e_learningman5.login.domain.use_case.LoginUseCaseImp
import com.example.e_learningman5.login.feature.LoginViewModel
import com.pddstudio.preferences.encrypted.EncryptedPreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *
 * Shared Preferences Module
 * */
private val persistence = module {
    single<EncryptedPreferences> {
        EncryptedPreferences.Builder(get()).withEncryptionPassword(Constants.PREF_PASSWORD).build()
    }
    single {
        appSharedPreferences(androidApplication())
    }
    single<SharedPreferences.Editor> {
        appSharedPreferences(androidApplication()).edit()
    }
}

/**
 *
 * Login Module
 * */
private val loginModule = module {
    // ServiceHelper
    factory<LoginApiServiceHelper> { LoginApiServiceHelperImp(get()) }
    factory<LoginDatabaseHelper> { LoginDatabaseHelperImp(get()) }
    factory<LoginPreferencesHelper> { LoginPreferencesHelperImp(get()) }

    // Repository
    single<LoginRepository> { LoginRepositoryImpl(get(), get(), get()) }

    // UseCase
    factory<LoginUseCase> { LoginUseCaseImp(get()) }

    // ViewModel
    viewModel { LoginViewModel(get()) }
}

/**
 *
 * Database Module
 * */
private val databaseModule = module {
    single { AppDatabase.getInstance(androidContext()) }
    single { get<AppDatabase>().appDao() }
}

// Add module to allModules for use
val allModules = listOf(
    loginModule,
    persistence,
    databaseModule,
    serviceModule
)