package com.example.e_learningman5.core.data.local.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "student")
data class StudentEntity(
    val name: String,
    val email: String,
    val image: String? = null,
    @ColumnInfo(name = "last_login")
    val lastLogin: LocalDateTime? = null,
    val phone: String? = null,
    @ColumnInfo(name = "student_class")
    val studentClass: String? = null,
    val major: String? = null,
    val address: String? = null,
    @PrimaryKey
    val nis: String,
)