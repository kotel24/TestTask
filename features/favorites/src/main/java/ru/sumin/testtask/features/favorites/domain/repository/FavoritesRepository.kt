package ru.sumin.testtask.features.favorites.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sumin.testtask.features.favorites.domain.entity.Course

interface FavoritesRepository {
    fun getFavoriteCourses(): Flow<List<Course>>

    suspend fun removeFavorite(course: Course)
}