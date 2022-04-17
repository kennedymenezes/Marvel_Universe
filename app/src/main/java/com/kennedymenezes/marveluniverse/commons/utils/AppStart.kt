package com.kennedymenezes.marveluniverse.commons.utils

import android.app.Application
import com.kennedymenezes.marveluniverse.commons.di.repositoryModule
import com.kennedymenezes.marveluniverse.commons.di.viewModelModule
import com.kennedymenezes.marveluniverse.commons.di.webServiceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppStart : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppStart)
            modules(webServiceModule, repositoryModule, viewModelModule)
        }
    }
}