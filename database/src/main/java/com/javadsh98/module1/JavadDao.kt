package com.javadsh98.module1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JavadDao {

    @Query("select * from Javad")
    fun getjavad(): LiveData<List<Javad>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(javad: Javad)

}