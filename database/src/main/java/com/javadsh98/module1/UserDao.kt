package com.javadsh98.module1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("select * from User")
    fun getUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(User: User)

    @Query("select * from  User where username like :username and password like :password")
    fun hasThisUser(username: String, password: String): LiveData<User>

}