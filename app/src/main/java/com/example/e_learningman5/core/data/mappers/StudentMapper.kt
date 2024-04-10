package com.example.e_learningman5.core.data.mappers

import com.example.e_learningman5.core.data.local.db.entities.StudentEntity
import com.example.e_learningman5.login.data.remote.LoginResponse
import com.example.e_learningman5.main.feature.profile.data.ProfileResponse
import java.time.LocalDateTime

// Data From Remote (Login) to Local DB
fun LoginResponse.toStudentEntity(): StudentEntity {
    return StudentEntity(
        name = name,
        email = email,
        lastLogin = LocalDateTime.now(),
        nis = siswa.nis,
    )
}

fun ProfileResponse.toStudentEntity(): StudentEntity {
    return StudentEntity(
        name = name,
        email = email,
        image = gambar,
        phone = no_hp,
        studentClass = nama_kelas,
        major = nama_jurusan,
        address = alamat,
        nis = nis
    )
}