package com.apptolast.kmptest.di

import com.apptolast.kmptest.BuildConfig
import com.apptolast.kmptest.interfaces.version.Greeting
import com.apptolast.kmptest.screens.HomeListViewModel
import io.kotzilla.sdk.analytics.koin.analytics
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
//import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.qualifier.named
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


val appModule = module {
    single(named("testApiKey")) { BuildConfig.TEST_API_KEY }
    factory { Greeting() }
}

val viewModelsModule = module {
    viewModelOf(::HomeListViewModel)
}

expect val nativeModule: Module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(appModule, viewModelsModule, nativeModule)

        // Kotzilla
        analytics {
            setApiKey(BuildConfig.TEST_API_KEY) // Available in the kotzilla.json file
            setVersion("0.1.0")
        }
    }

// called by iOS
fun initKoinIos() = initKoin() {}