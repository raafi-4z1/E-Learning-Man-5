package com.example.e_learningman5.core.domain.use_case

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)