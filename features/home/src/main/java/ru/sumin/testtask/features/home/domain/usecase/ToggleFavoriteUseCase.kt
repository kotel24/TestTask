package ru.sumin.testtask.features.home.domain.usecase

import ru.sumin.testtask.features.home.domain.entity.Course
import ru.sumin.testtask.features.home.domain.repository.CoursesRepository

class ToggleFavoriteUseCase(
    private val repository: CoursesRepository
) {
    suspend operator fun invoke(course: Course) {
        repository.toggleFavoriteStatus(course)
    }
}