package io.beomjo.multinav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.beomjo.multinav.ui.company.CompanyScreen
import io.beomjo.multinav.ui.home.HomeScreen
import io.beomjo.multinav.ui.more.MoreScreen
import io.beomjo.multinav.ui.notification.NotificationScreen

@Composable
fun MyAppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = MyAppDestinations.HOME_ROUTE
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(MyAppDestinations.HOME_ROUTE) {
            HomeScreen()
        }
        composable(MyAppDestinations.COMPANY_ROUTE) {
            CompanyScreen()
        }
        composable(MyAppDestinations.NOTIFICATION_ROUTE) {
            NotificationScreen()
        }
        composable(MyAppDestinations.MORE_ROUTE) {
            MoreScreen()
        }
    }
}