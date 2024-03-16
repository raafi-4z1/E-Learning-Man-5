package com.example.e_learningman5.login.domain.use_case

import android.util.Patterns
import com.example.e_learningman5.core.domain.use_case.validate.ValidationResult
import com.example.e_learningman5.core.domain.use_case.validate.ValidationUseCase

class ValidateEmail: ValidationUseCase {
    override suspend fun execute(param: String): ValidationResult {
        if (param.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The email can't be blank"
            )
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(param).matches()) {
            return ValidationResult(
                successful = false,
                errorMessage = "That's not a valid email"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}