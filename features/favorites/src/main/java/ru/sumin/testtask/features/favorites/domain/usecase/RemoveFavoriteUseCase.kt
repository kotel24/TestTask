package ru.sumin.testtask.features.favorites.domain.usecase

import ru.sumin.testtask.features.favorites.domain.entity.Course
import ru.sumin.testtask.features.favorites.domain.repository.FavoritesRepository

class RemoveFavoriteUseCase(
    private val repository: FavoritesRepository
) {
    suspend operator fun invoke(course: Course) {
        repository.removeFavorite(course)
    }
}