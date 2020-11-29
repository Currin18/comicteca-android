package com.jesusmoreira.comicteca.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.emptyContent
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.ui.tooling.preview.Preview
import com.jesusmoreira.comicteca.R

@Preview
@Composable
fun PreviewBottomAppBar() {
    BottomActionBar(
        rememberNavController(), listOf(
        BottomNavigationScreen.Comicteca,
        BottomNavigationScreen.News,
        BottomNavigationScreen.Community,
    ))
}

@Composable
fun BottomActionBar(
    navController: NavHostController,
    items: List<BottomNavigationScreen>
) {
    BottomNavigation {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon) },
                label = { Text(stringResource(id = screen.resourceId)) },
                selected = currentRoute == screen.route,
                alwaysShowLabels = false,   // this hides the title
                // for the unselected items
                onClick = {
                    // This if check gives us  a "singleTop behavior
                    // where we do not create a second instance of the
                    // composable if we are already on that destination
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                },
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}

sealed class BottomNavigationScreen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: VectorAsset
) {
    object Comicteca: BottomNavigationScreen("Comicteca",
        R.string.route_comicteca, Icons.Filled.Notifications)
    object News: BottomNavigationScreen("News",
        R.string.route_news, Icons.Filled.Notifications)
    object Community: BottomNavigationScreen("Community",
        R.string.route_community, Icons.Filled.Notifications)
}

@Composable
fun BottomActionBarController(
    navController: NavHostController,
    onComicteca: @Composable () -> Unit = emptyContent(),
    onNews: @Composable () -> Unit = emptyContent(),
    onCommunity: @Composable () -> Unit = emptyContent(),
) = NavHost(
    navController,
    startDestination = BottomNavigationScreen.Comicteca.route
) {
    composable(BottomNavigationScreen.Comicteca.route) {
        onComicteca()
    }
    composable(BottomNavigationScreen.News.route) {
        onNews()
    }
    composable(BottomNavigationScreen.Community.route) {
        onCommunity()
    }
}