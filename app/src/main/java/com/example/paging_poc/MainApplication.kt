package com.example.paging_poc

import android.app.Application
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(appModules)
        }
    }
}