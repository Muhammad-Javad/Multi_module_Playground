package com.javadsh98.module1

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [Javad::class], version = 1, exportSchema = false)
abstract class JDataBase: RoomDatabase() {

    abstract fun getDao(): JavadDao

}