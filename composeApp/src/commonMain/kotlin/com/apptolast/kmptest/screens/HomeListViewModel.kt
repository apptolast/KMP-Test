package com.apptolast.kmptest.screens

import androidx.lifecycle.ViewModel
import com.apptolast.kmptest.interfaces.version.Greeting
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeListViewModel : ViewModel(), KoinComponent {
    private val greeting: Greeting by inject()

    val greetingText = greeting.greet()
}
