package com.apptolast.kmptest

import android.app.Application
import android.content.Context

class MyApplication : Application() {
    lateinit var appContext: Context
        private set // Make it private to prevent external modification

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        instance = this // Initialize the instance here
    }

    companion object {
        @Volatile
        private var instance: MyApplication? = null

        fun getInstance(): MyApplication {
            return instance ?: synchronized(this) {
                instance ?: throw IllegalStateException("App instance not initialized")
            }
        }
    }
}