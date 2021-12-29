package io.beomjo.multinav.ui.company

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.beomjo.multinav.ui.detail.DetailScreen

enum class CompanyDirections(val route: String) {
    ROOT("company/"),
    DETAIL("company/detail"),
    DETAIL2("company/detail2"),
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
        DetailScreen(from = CompanyDirections.DETAIL.route) {
            Button(onClick = {
                navController.navigate(CompanyDirections.DETAIL2.route)
            }) {
                Text("Move To Detail 2")
            }
        }
    }

    composable(CompanyDirections.DETAIL2.route) {
        DetailScreen(from = CompanyDirections.DETAIL.route + "2")
    }
}