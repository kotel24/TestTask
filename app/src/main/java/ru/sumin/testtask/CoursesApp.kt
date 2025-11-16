package ru.sumin.testtask

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.sumin.testtask.core.network.di.networkModule
import ru.sumin.testtask.features.auth.di.authModule

class CoursesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@CoursesApp)
            modules(listOf(networkModule, authModule))
        }
    }
}