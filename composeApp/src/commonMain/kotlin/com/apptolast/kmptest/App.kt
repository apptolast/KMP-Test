package com.apptolast.kmptest

import androidx.compose.runtime.Composable
import com.apptolast.kmptest.screens.navigation.Navigation
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    SurfaceScreen {
        Navigation()
    }
}
