package io.beomjo.multinav.ui.company

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.beomjo.multinav.ui.detail.DetailScreen

enum class CompanyDirections(val route: String) {
    ROOT("company/"),
    DETAIL("company/detail"),
}

fun NavGraphBuilder.addCompanyGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(CompanyDirections.ROOT.route) {
        CompanyScreen {
            navController.navigate(CompanyDirections.DETAIL.route)
        }
    }
    composable(CompanyDirections.DETAIL.route) {
        DetailScreen(from = CompanyDirections.DETAIL.route)
    }
}