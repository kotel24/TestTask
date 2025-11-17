package ru.sumin.testtask.features.favorites.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.sumin.testtask.core.database.dao.FavoritesDao
import ru.sumin.testtask.features.favorites.domain.repository.FavoritesRepository
import ru.sumin.testtask.features.favorites.data.mapper.toEntity
import ru.sumin.testtask.features.favorites.domain.entity.Course

class FavoritesRepositoryImpl(
    private val dao: FavoritesDao
) : FavoritesRepository {

    override fun getFavoriteCourses(): Flow<List<Course>> {
        return dao.getFavoriteCourses().map { dbModels ->
            dbModels.map { it.toEntity() }
        }
    }

    override suspend fun removeFavorite(course: Course) {
        dao.removeFromFavorite(course.id)
    }
}