package io.beomjo.multinav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.beomjo.multinav.ui.company.CompanyDirections
import io.beomjo.multinav.ui.home.HomeDirections
import io.beomjo.multinav.ui.more.MoreDirections
import io.beomjo.multinav.ui.notification.NotificationDirections
import io.beomjo.multinav.ui.theme.MyAppTheme

@Composable
fun MyApp() {
    MyAppTheme {
        val navController = rememberNavController()

        Scaffold(
            bottomBar = { MyBottomNavigation(navController = navController) }
        ) {
            MyAppNavGraph(navController = navController)
        }
    }
}

enum class TabDirections(val route:String) {
    HOME("home"),
    COMPANY("company"),
    NOTIFICATION("notification"),
    MORE("more"),

}

@Composable
fun MyBottomNavigation(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute =
        navBackStackEntry?.destination?.route ?: TabDirections.HOME
    val tabs = TabDirections.values().map { it.route }.toList()
    BottomNavigation {
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = {},
                label = { Text(text = tab, fontSize = 9.sp) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == tab,
                onClick = {
                    if (currentRoute.toString().startsWith(tab)) {
                        navController.navigate(findTabRootRoute(tab)) {
                            popUpTo(findStartDestination(navController.graph).id)
                        }
                    } else if (tab != currentRoute) {
                        navController.navigate(tab) {
                            launchSingleTop = true
                            restoreState = true
                            // Pop up backstack to the first destination and save state. This makes going back
                            // to the start destination when pressing back in any other bottom tab.
                            val startDestination = findStartDestination(navController.graph)
                            popUpTo(startDestination.id) {
                                saveState = true
                            }
                        }
                    }
                }
            )
        }
    }
}

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private fun findTabRootRoute(tab: String): String {
    return when (tab) {
        TabDirections.HOME.route -> HomeDirections.ROOT.route
        TabDirections.COMPANY.route -> CompanyDirections.ROOT.route
        TabDirections.NOTIFICATION.route -> NotificationDirections.ROOT.route
        else -> MoreDirections.ROOT.route
    }
}