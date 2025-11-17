package ru.sumin.testtask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.sumin.testtask.core.ui.theme.AppDarkGray
import ru.sumin.testtask.core.ui.theme.AppGreen
import ru.sumin.testtask.core.ui.theme.AppLightGray
import ru.sumin.testtask.core.ui.theme.AppStroke
import ru.sumin.testtask.core.ui.theme.AppWhite
import ru.sumin.testtask.features.auth.presentation.LoginScreen
import ru.sumin.testtask.features.favorites.presentation.FavoritesScreen
import ru.sumin.testtask.features.home.presentation.HomeScreen
import ru.sumin.testtask.features.profile.presentation.ProfileScreen

@Composable
fun CoursesAppContent() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val navigationItems = listOf(
        NavigationItem.Home,
        NavigationItem.Favorites,
        NavigationItem.Profile
    )

    Scaffold(
        bottomBar = {
            if (currentRoute in navigationItems.map { it.route }) {
                Column(modifier = Modifier.background(AppDarkGray)) {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = AppStroke
                    )

                    NavigationBar(
                        containerColor = AppDarkGray
                    ) {
                        navigationItems.forEach { item ->
                            val isSelected = navBackStackEntry?.destination?.hierarchy
                                ?.any { it.route == item.route } == true

                            NavigationBarItem(
                                selected = isSelected,
                                onClick = {
                                    navController.navigate(item.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = item.icon),
                                        contentDescription = null
                                    )
                                },
                                label = { Text(item.title) },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = AppGreen,
                                    selectedTextColor = AppGreen,
                                    indicatorColor = AppLightGray,
                                    unselectedIconColor = AppWhite,
                                    unselectedTextColor = AppWhite
                                )
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("login") {
                LoginScreen(
                    onLoginSuccess = {
                        navController.navigate(NavigationItem.Home.route) {
                            popUpTo("login") { inclusive = true }
                        }
                    }
                )
            }
            composable(NavigationItem.Home.route) {
                HomeScreen()
            }
            composable(NavigationItem.Favorites.route) {
                FavoritesScreen()
            }
            composable(NavigationItem.Profile.route) {
                ProfileScreen()
            }
        }
    }
}