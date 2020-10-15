package com.javadsh98.module1

import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {

    single {
        Room.databaseBuilder(androidContext(), UserDataBase::class.java, "javad database")
            .allowMainThreadQueries()
            .build()
    }

    single { get<UserDataBase>().getDao() }

}