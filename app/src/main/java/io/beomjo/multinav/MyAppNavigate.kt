package io.beomjo.multinav

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object MyAppDestinations {
    const val HOME_ROUTE = "home"
    const val COMPANY_ROUTE = "company"
    const val NOTIFICATION_ROUTE = "notification"
    const val MORE_ROUTE = "more"
}

class MyAppActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(MyAppDestinations.HOME_ROUTE) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
    val navigateToCompany: () -> Unit = {
        navController.navigate(MyAppDestinations.COMPANY_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToNotification: () -> Unit = {
        navController.navigate(MyAppDestinations.NOTIFICATION_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToMore: () -> Unit = {
        navController.navigate(MyAppDestinations.MORE_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}