package com.apptolast.kmptest

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.apptolast.kmptest.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(InstrumentationRegistry.getInstrumentation().targetContext.applicationContext)
        }
    }
}