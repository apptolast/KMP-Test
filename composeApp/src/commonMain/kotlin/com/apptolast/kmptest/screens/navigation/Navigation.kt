package com.apptolast.kmptest.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.apptolast.kmptest.screens.ConfigFieldScreen
import com.apptolast.kmptest.screens.HomeScreen
import com.apptolast.kmptest.screens.NavigationFeatureScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeDestination,
        modifier = modifier,
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

        composable<ConfigFieldDestination> { backStackEntry ->
            val (title) = backStackEntry.toRoute<ConfigFieldDestination>()
            ConfigFieldScreen(
                title = title,
                navigateBack = navController::navigateUp
            )
        }
    }
}