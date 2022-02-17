package com.example.ioasysbooks.activity

import android.app.Application
import com.example.ioasysbooks.di.*
import domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(
                PresentationModule,
                dataModule,
                dataRemoteModule,
                dataLocalModule,
                databaseModule,
                domainModule
            ).androidContext(applicationContext)
        }
    }
}