package com.example.e_learningman5.core.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.e_learningman5.core.data.local.db.entities.StudentEntity
import java.time.LocalDateTime

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(studentEntity: StudentEntity)

    @Query("SELECT * FROM student WHERE nis=:nis")
    suspend fun selectStudent(nis: String): StudentEntity

    @Query("UPDATE student SET last_login=:lastLogin WHERE nis=:nis")
    suspend fun setSession(lastLogin: LocalDateTime?, nis: String)

    @Query("SELECT last_login FROM student WHERE nis=:nis")
    suspend fun getSession(nis: String): LocalDateTime?
}