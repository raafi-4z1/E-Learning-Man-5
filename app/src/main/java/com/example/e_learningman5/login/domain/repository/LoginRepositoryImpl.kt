package com.example.e_learningman5.login.domain.repository

import android.util.Log
import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.core.data.remote.response.MyResponse
import com.example.e_learningman5.core.data.services.login.LoginApiServiceHelper
import com.example.e_learningman5.core.data.services.login.LoginDatabaseHelper
import com.example.e_learningman5.core.data.services.login.LoginPreferencesHelper
import com.example.e_learningman5.core.domain.repository.login.LoginRepository
import com.example.e_learningman5.login.data.remote.LoginResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.json.JSONException
import org.json.JSONObject
import java.time.LocalDateTime

class LoginRepositoryImpl(
    private val loginPreferencesHelper: LoginPreferencesHelper,
    private val loginApiServiceHelper: LoginApiServiceHelper,
    private val loginDatabaseHelper: LoginDatabaseHelper
) : LoginRepository {
    override suspend fun getDataLogin(email: String, password: String) =
        flow<MyResponse<ApiResponse<LoginResponse>>> {
            emit(MyResponse.Loading())
            with(loginApiServiceHelper.getDataLogin(email, password)) {
                if (isSuccessful) {
                    this.body()?.data?.let {
                        it.siswa.let { siswa -> setLogin(siswa.nis, siswa.token) }
                        loginDatabaseHelper.insertDataLogin(it)
                    }
                    emit(MyResponse.Success(this.body()))
                } else {
                    val errorMessage = try {
                        this.errorBody()?.string()?.let {
                            Log.d("TAG, getDataLogin: ", it)
                            JSONObject(it).getString("message")
                        }
                    } catch (e: JSONException) {
                        null
                    }
                    emit(MyResponse.Error(errorMessage.toString()))
                }
            }
        }.catch { emit(MyResponse.Error(it.localizedMessage)) }

    override suspend fun setLogin(nis: String, token: String) {
        loginPreferencesHelper.setLogin(nis, token)
    }

    override suspend fun getNis(): String? = loginPreferencesHelper.getNis()

    override suspend fun setSession(nis: String) {
        loginDatabaseHelper.setSession(nis)
    }

    override suspend fun getSession(nis: String): LocalDateTime? =
        loginDatabaseHelper.getSession(nis)
}