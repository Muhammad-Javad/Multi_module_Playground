package com.javadsh98.module1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Javad(@PrimaryKey@ColumnInfo(name = "age") val age: Int)