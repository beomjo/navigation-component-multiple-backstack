package io.beomjo.multinav.ui.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.beomjo.multinav.ui.detail.DetailScreen

enum class HomeDirections(val route: String) {
    ROOT("home/"),
    DETAIL("home/detail"),
}

fun NavGraphBuilder.addHomeGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(HomeDirections.ROOT.route) {
        HomeScreen {
            navController.navigate(HomeDirections.DETAIL.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }
    composable(HomeDirections.DETAIL.route) {
        DetailScreen(from = HomeDirections.DETAIL.route)
    }
}