package com.apptolast.kmptest.screens

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.apptolast.kmptest.di.appModule
import com.apptolast.kmptest.screens.navigation.ConfigFieldDestination
import com.apptolast.kmptest.screens.navigation.HomeDestination
import com.apptolast.kmptest.screens.navigation.NavigationFeatureDestination
import com.apptolast.kmptest.testrule.KoinTestRule
import org.junit.Before
import org.junit.Rule
import kotlin.test.Test

class HomeListViewModelAndroidTest {

//    @get:Rule(order = 0)
//    val composeTestRule =
//        createAndroidComposeRule<TestMainActivity>()

    @get:Rule(order = 0)
    val composeTestRule = createComposeRule()

    @get:Rule(order = 1)
    val koinTestRule = KoinTestRule(listOf(appModule))

    @Before
    fun setup() {

        composeTestRule.setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = HomeDestination,
            ) {

                composable<HomeDestination> {
                    HomeScreen(
                        navigateToNavigationFeature = { title ->
                            navController.navigate(NavigationFeatureDestination(title))
                        },
                        navigateToConfigFieldFeature = { title ->
                            navController.navigate(ConfigFieldDestination(title))
                        }
                    )
                }

                composable<NavigationFeatureDestination> { backStackEntry ->
                    val (title) = backStackEntry.toRoute<NavigationFeatureDestination>()
                    NavigationFeatureScreen(
                        title = title,
                        navigateBack = navController::navigateUp
                    )
                }
            }
        }
    }

    @Test
    fun homeListView_checkVersionCode() {
        val greeting = "Mocked Greeting!"

        composeTestRule
            .onNodeWithTag("version_label")
            .assertTextEquals(greeting)
    }

    @Test
    fun homeListView_testNavigation() {
        composeTestRule.onNodeWithText("Navigation").performClick()

        composeTestRule.onNodeWithTag("counter_value").assertTextEquals("0")
        composeTestRule.onNodeWithTag("increment_button").performClick()
        composeTestRule.onNodeWithTag("counter_value").assertTextEquals("1")
    }
}