@file:OptIn(ExperimentalTestApi::class)

package com.apptolast.kmptest.screens

import android.content.Context
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import androidx.test.core.app.ApplicationProvider
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.Test

class NavigationFeatureScreenAndroidTest {

    @Test
    fun testPackageName() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        assertThat(context.packageName).isEqualTo("com.apptolast.kmptest")
    }

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