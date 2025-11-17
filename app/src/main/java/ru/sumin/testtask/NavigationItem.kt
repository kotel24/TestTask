package ru.sumin.testtask

sealed class NavigationItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : NavigationItem(
        route = "home",
        title = "Главная",
        icon = ru.sumin.testtask.core.ui.R.drawable.home
    )
    object Favorites : NavigationItem(
        route = "favorites",
        title = "Избранное",
        icon = ru.sumin.testtask.core.ui.R.drawable.favourite
    )
    object Profile : NavigationItem(
        route = "profile",
        title = "Аккаунт",
        icon = ru.sumin.testtask.core.ui.R.drawable.profile
    )
}