package ru.sumin.testtask.features.favorites.presentation

import ru.sumin.testtask.features.favorites.domain.entity.Course

data class FavoritesState(
    val courses: List<Course> = emptyList(),
    val isLoading: Boolean = false
)