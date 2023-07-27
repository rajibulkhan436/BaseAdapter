package com.rajibul.baseadapter

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class studentDataClass(
    @PrimaryKey(autoGenerate = true)
    var id: Long =0L,

    @ColumnInfo
    var name: String?=null

)
