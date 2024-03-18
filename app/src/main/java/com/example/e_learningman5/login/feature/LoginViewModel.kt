package com.example.e_learningman5.login.feature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_learningman5.core.data.remote.response.MyResponse
import com.example.e_learningman5.core.domain.use_case.login.LoginUseCase
import com.example.e_learningman5.core.domain.use_case.validate.ValidationUseCase
import com.example.e_learningman5.core.util.ErrorsMessage
import com.example.e_learningman5.login.domain.model.RegistrationFormEvent
import com.example.e_learningman5.login.domain.model.RegistrationFormState
import com.example.e_learningman5.login.domain.model.ValidationEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 *
 * Login Validation, by: https://youtu.be/zu8lQSVw4vk?si=ba57-iY6u3zSyd7U
 * */
class LoginViewModel(
    private val loginUseCase: LoginUseCase,
    private val validateEmail: ValidationUseCase,
    private val validatePassword: ValidationUseCase
) : ViewModel() {
    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    init {
        checkSession()
    }

    private fun checkSession() {
        viewModelScope.launch(Dispatchers.IO) {
            loginUseCase.getSession().let {
                if (it == null)
                    validationEventChannel.send(ValidationEvent.Error("null"))
                else
                    if (it)
                        validationEventChannel.send(ValidationEvent.Success)
                    else
                        validationEventChannel.send(ValidationEvent.Error("Silahkan Login Kembali"))
            }
        }
    }

    fun onEvent(event: RegistrationFormEvent) {
        when (event) {
            is RegistrationFormEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }

            is RegistrationFormEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }

            is RegistrationFormEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        viewModelScope.launch(Dispatchers.IO) {
            val emailResult = validateEmail.execute(state.email)
            val passwordResult = validatePassword.execute(state.password)

            val hasError = listOf(
                emailResult,
                passwordResult
            ).any { !it.successful }

            state = state.copy(
                emailError = emailResult.errorMessage,
                passwordError = passwordResult.errorMessage
            )

            if (!hasError)
                loginUseCase.getDataLogin(state.email, state.password).collect {
                    when (it) {
                        is MyResponse.Success -> validationEventChannel.send(ValidationEvent.Success)

                        is MyResponse.Error -> validationEventChannel.send(
                            ValidationEvent.Error(
                                it.message ?: ErrorsMessage.gotApiCallError
                            )
                        )

                        is MyResponse.Loading -> {}
                    }
                }
        }
    }
}