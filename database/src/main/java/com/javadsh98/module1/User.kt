package com.javadsh98.module1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val username: String,
    val firstname: String,
    val lastname: String,
    val password: String,
    val email: String
)