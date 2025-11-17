package ru.sumin.testtask.features.home.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.sumin.testtask.features.home.domain.repository.CoursesRepository

class ObserveFavoriteUseCase(
    private val repository: CoursesRepository
) {
    operator fun invoke(courseId: Int): Flow<Boolean> {
        return repository.observeIsFavorite(courseId)
    }
}