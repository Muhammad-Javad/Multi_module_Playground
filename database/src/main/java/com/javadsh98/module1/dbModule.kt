package com.javadsh98.module1

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {

    single {
        Room.databaseBuilder(androidContext(), JDataBase::class.java, "javad database")
            .allowMainThreadQueries()
            .build()
    }

    single { get<JDataBase>().getDao() }

}