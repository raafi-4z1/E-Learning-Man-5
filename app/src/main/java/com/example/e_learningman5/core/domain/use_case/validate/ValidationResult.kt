package com.example.e_learningman5.core.domain.use_case.validate

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)