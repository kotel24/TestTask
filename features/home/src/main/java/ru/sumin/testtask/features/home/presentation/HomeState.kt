package ru.sumin.testtask.features.home.presentation

import ru.sumin.testtask.features.home.domain.entity.Course

data class HomeState(
    val courses: List<Course> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)