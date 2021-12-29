package io.beomjo.multinav.ui.more

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.beomjo.multinav.ui.detail.DetailScreen

enum class MoreDirections(val route: String) {
    ROOT("more/"),
    DETAIL("more/detail"),
}

fun NavGraphBuilder.addMoreGraph(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable(MoreDirections.ROOT.route) {
        MoreScreen {
            navController.navigate(MoreDirections.DETAIL.route)
        }
    }
    composable(MoreDirections.DETAIL.route) {
        DetailScreen(from = MoreDirections.DETAIL.route)
    }
}