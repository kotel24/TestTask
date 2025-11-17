package ru.sumin.testtask.features.favorites.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.sumin.testtask.features.favorites.domain.repository.FavoritesRepository
import ru.sumin.testtask.features.favorites.domain.entity.Course

class GetFavoriteCoursesUseCase(
    private val repository: FavoritesRepository
) {
    operator fun invoke(): Flow<List<Course>> {
        return repository.getFavoriteCourses()
    }
}