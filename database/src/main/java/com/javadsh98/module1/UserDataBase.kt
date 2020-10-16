package com.javadsh98.module1

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [User::class], version = 2, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {

    abstract fun getDao(): UserDao

}