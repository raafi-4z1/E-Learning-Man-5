package com.example.e_learningman5.login.domain.use_case

import com.example.e_learningman5.core.data.remote.response.ApiResponse
import com.example.e_learningman5.core.data.remote.response.MyResponse
import com.example.e_learningman5.core.domain.repository.login.LoginRepository
import com.example.e_learningman5.core.domain.use_case.login.LoginUseCase
import com.example.e_learningman5.login.data.remote.LoginResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDateTime

class LoginUseCaseImp(
    private val loginRepository: LoginRepository
) : LoginUseCase {
    override suspend fun getDataLogin(
        email: String,
        password: String
    ): Flow<MyResponse<ApiResponse<LoginResponse>>> = flow {
        loginRepository.getDataLogin(email, password).collect {
            when (it) {
                is MyResponse.Success -> emit(MyResponse.Success(it.data))

                is MyResponse.Error -> emit(MyResponse.Error(it.message))

                is MyResponse.Loading -> emit(MyResponse.Loading())
            }
        }
    }

    override suspend fun getSession(): Boolean? {
        val nis = loginRepository.getNis()
        if (nis != null) {
            loginRepository.getSession(nis).let { lastLogin ->
                if (lastLogin != null) {
                    return if (lastLogin.isAfter(LocalDateTime.now().minusDays(5))) {
                        true
                    } else {
                        loginRepository.setSession(nis)
                        loginRepository.setLogin("", "")
                        false
                    }
                }
            }
        }
        return null
    }
}