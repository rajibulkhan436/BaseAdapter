package com.rajibul.baseadapter

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {
    @Insert
    fun insertStudent(studentDataClass: studentDataClass)

    @Query("SELECT * FROM studentDataClass")
    fun getstudentlist(): List<studentDataClass>

    @Delete
    fun deleteStudent(studentDataClass: studentDataClass)
}