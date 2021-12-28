package io.beomjo.multinav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.beomjo.multinav.ui.theme.MyAppTheme

@Composable
fun MyApp() {
    MyAppTheme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            MyAppActions(navController)
        }

        Scaffold(
            bottomBar = { MyBottomNavigation(navController = navController) }
        ) {
            MyAppNavGraph(navController = navController)
        }
    }
}

@Composable
fun MyBottomNavigation(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute =
        navBackStackEntry?.destination?.route ?: MyAppDestinations.HOME_ROUTE

    val items = listOf(
        MyAppDestinations.HOME_ROUTE,
        MyAppDestinations.COMPANY_ROUTE,
        MyAppDestinations.NOTIFICATION_ROUTE,
        MyAppDestinations.MORE_ROUTE,
    )
    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {

                },
                label = {
                    Text(
                        text = item,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item,
                onClick = {
                    navController.navigate(item) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}