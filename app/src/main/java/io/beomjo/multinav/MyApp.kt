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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.beomjo.multinav.ui.home.HomeDirections
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

@Composable
fun MyBottomNavigation(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute =
        navBackStackEntry?.destination?.route ?: TabDirections.HOME
    val tabs = TabDirections.values().map { it.route }.toList()
    BottomNavigation {
        tabs.forEach { item ->
            BottomNavigationItem(
                icon = {},
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
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
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