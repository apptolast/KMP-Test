package com.apptolast.kmptest.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

actual val nativeModule: Module = module {
    single { androidContext() }
}