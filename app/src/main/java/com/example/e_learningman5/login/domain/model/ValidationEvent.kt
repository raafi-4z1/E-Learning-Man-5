package com.example.e_learningman5.login.domain.model

sealed class ValidationEvent(val message: String? = null) {
    object Success : ValidationEvent()
    class Error(message: String) : ValidationEvent(message)
}