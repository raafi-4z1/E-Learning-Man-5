package com.example.e_learningman5.login.data.remote

data class LoginResponse(
    val name: String,
    val email: String,
    val siswa: Siswa
)

data class Siswa(
    val nis: String,
    val token: String
)