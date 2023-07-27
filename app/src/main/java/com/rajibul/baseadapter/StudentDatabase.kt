package com.rajibul.baseadapter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [studentDataClass::class])
abstract class StudentDatabase :RoomDatabase(){
    abstract fun studentDao() : StudentDao

    companion object{
        var studentDatabase : StudentDatabase ?= null
        fun getDatabase (context: Context) : StudentDatabase{
            if(studentDatabase == null) {
                studentDatabase = Room.databaseBuilder(
                    context,
                    StudentDatabase::class.java,
                    "Student Database"
                ).build()
            }
            return studentDatabase!!
        }
    }
}