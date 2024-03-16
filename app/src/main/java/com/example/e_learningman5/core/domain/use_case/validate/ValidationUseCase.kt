package com.example.e_learningman5.core.domain.use_case.validate

interface ValidationUseCase {
    suspend fun execute(param: String): ValidationResult
}