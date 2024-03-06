package com.example.e_learningman5.login.feature

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_learningman5.core.domain.use_case.ValidateEmail
import com.example.e_learningman5.core.domain.use_case.ValidatePassword
import com.example.e_learningman5.login.domain.model.RegistrationFormEvent
import com.example.e_learningman5.login.domain.model.RegistrationFormState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 *
 * Login Validation, by: https://youtu.be/zu8lQSVw4vk?si=ba57-iY6u3zSyd7U
 * */
class LoginViewModel(
    private val validateEmail: ValidateEmail = ValidateEmail(),
    private val validatePassword: ValidatePassword = ValidatePassword()
) : ViewModel() {
    var state by mutableStateOf(RegistrationFormState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

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

        if (hasError) {
            return
        }
        viewModelScope.launch {
            validationEventChannel.send(ValidationEvent.Success)
        }
    }

    sealed class ValidationEvent {
        object Success : ValidationEvent()
    }
}