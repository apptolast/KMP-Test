@file:OptIn(ExperimentalTestApi::class)

package com.apptolast.kmptest.screens

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

class NavigationFeatureScreenTest {

    @Test
    fun testIncrementCounter() = runComposeUiTest {

        setContent {
            NavigationFeatureContent()
        }
        onNodeWithTag("counter_value").assertTextEquals("0")
        onNodeWithTag("increment_button").performClick()
        onNodeWithTag("counter_value").assertTextEquals("1")
    }
}