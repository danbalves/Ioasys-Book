package com.example.ioasysbooks.activity

import android.app.Application
import com.example.ioasysbooks.di.PresentationModule
import com.example.ioasysbooks.di.dataModule
import com.example.ioasysbooks.di.dataRemoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(
                PresentationModule,
                dataModule,
                dataRemoteModule
            ).androidContext(applicationContext)
        }
    }
}