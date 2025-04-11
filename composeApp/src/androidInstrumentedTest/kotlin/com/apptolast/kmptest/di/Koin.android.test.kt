package com.apptolast.kmptest.di

import com.apptolast.kmptest.interfaces.version.Greeting
import io.mockk.every
import io.mockk.mockk
import org.koin.dsl.module

val appModule = module {
//    factory { mockk<Greeting>() }
    factory {
        mockk<Greeting> {
            every { greet() } returns "Mocked Greeting!" // Example mock behavior
        }
    }
}