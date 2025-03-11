package com.apptolast.kmptest

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.apptolast.kmptest.interfaces.toast
import com.apptolast.kmptest.screens.HomeList
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(
            screen = HomeList(),
            onBackPressed = { currentScreen ->
                toast("Pop screen #${(currentScreen as HomeList)}")
                true
            }
        )
    }
}