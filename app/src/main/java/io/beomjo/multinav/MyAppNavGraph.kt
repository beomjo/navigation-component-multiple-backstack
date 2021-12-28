package io.beomjo.multinav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import io.beomjo.multinav.ui.company.CompanyDirections
import io.beomjo.multinav.ui.company.addCompanyGraph
import io.beomjo.multinav.ui.home.HomeDirections
import io.beomjo.multinav.ui.home.addHomeGraph
import io.beomjo.multinav.ui.more.MoreDirections
import io.beomjo.multinav.ui.more.addMoreGraph
import io.beomjo.multinav.ui.notification.NotificationDirections
import io.beomjo.multinav.ui.notification.addNotificationGraph

@Composable
fun MyAppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = TabDirections.HOME.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        navigation(
            route = TabDirections.HOME.route,
            startDestination = HomeDirections.ROOT.route,
        ) {
            addHomeGraph(modifier, navController)
        }

        navigation(
            route = TabDirections.COMPANY.route,
            startDestination = CompanyDirections.ROOT.route,
        ) {
            addCompanyGraph(modifier, navController)
        }

        navigation(
            route = TabDirections.NOTIFICATION.route,
            startDestination = NotificationDirections.ROOT.route,
        ) {
            addNotificationGraph(modifier, navController)
        }

        navigation(
            route = TabDirections.MORE.route,
            startDestination = MoreDirections.ROOT.route,
        ) {
            addMoreGraph(modifier, navController)
        }
    }
}