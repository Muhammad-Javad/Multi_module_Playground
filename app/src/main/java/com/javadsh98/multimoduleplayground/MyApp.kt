package com.javadsh98.multimoduleplayground

import android.app.Application
import com.javadsh98.module1.dbModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            koin.loadModules(listOf(dbModule))
            koin.createRootScope()
        }

    }

}