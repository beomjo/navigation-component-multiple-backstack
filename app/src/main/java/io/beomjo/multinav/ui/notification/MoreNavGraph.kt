package io.beomjo.multinav.ui.notification

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.beomjo.multinav.ui.detail.DetailScreen

enum class NotificationDirections(val route: String) {
    ROOT("notification/"),
    DETAIL("notification/detail"),
}

fun NavGraphBuilder.addNotificationGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(NotificationDirections.ROOT.route) {
        NotificationScreen {
            navController.navigate(NotificationDirections.DETAIL.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }
    composable(NotificationDirections.DETAIL.route) {
        DetailScreen(from = NotificationDirections.DETAIL.route)
    }
}