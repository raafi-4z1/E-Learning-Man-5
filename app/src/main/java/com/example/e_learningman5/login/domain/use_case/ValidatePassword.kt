package com.example.e_learningman5.login.domain.use_case

import com.example.e_learningman5.core.domain.use_case.validate.ValidationResult
import com.example.e_learningman5.core.domain.use_case.validate.ValidationUseCase

class ValidatePassword : ValidationUseCase {
    override suspend fun execute(param: String): ValidationResult {
        if (param.length < 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "The password needs to consist of at least 8 characters"
            )
        }
//        val containsLettersAndDigits = password.any { it.isDigit() } &&
//                password.any { it.isLetter() }
//        if(!containsLettersAndDigits) {
//            return ValidationResult(
//                successful = false,
//                errorMessage = "The password needs to contain at least one letter and digit"
//            )
//        }
        return ValidationResult(
            successful = true
        )
    }
}