package ru.sumin.testtask.features.home.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import ru.sumin.testtask.core.database.dao.FavoritesDao
import ru.sumin.testtask.core.network.api.CoursesApi
import ru.sumin.testtask.features.home.data.mapper.toDbModel
import ru.sumin.testtask.features.home.data.mapper.toEntity
import ru.sumin.testtask.features.home.domain.entity.Course
import ru.sumin.testtask.features.home.domain.repository.CoursesRepository

class CoursesRepositoryImpl(
    private val api: CoursesApi,
    private val favoritesDao: FavoritesDao
) : CoursesRepository {

    private var cachedCourses: List<Course> = emptyList()

    override suspend fun getCourses(sortedByDate: Boolean): List<Course> {

        if (cachedCourses.isEmpty()) {
            val response = api.loadCourses()
            val favoriteIds = favoritesDao.getFavoriteIds()
            cachedCourses = response.courses.map { dto ->
                val isFav = dto.id in favoriteIds
                dto.toEntity(isFavorite = isFav)
            }
        } else {
            val favoriteIds = favoritesDao.getFavoriteIds()
            cachedCourses = cachedCourses.map { course ->
                course.copy(isFavorite = course.id in favoriteIds)
            }
        }

        return if (sortedByDate) {
            cachedCourses.sortedByDescending { it.publishDate }
        } else {
            cachedCourses
        }
    }

    override fun observeIsFavorite(courseId: Int): Flow<Boolean> {
        return favoritesDao.observeIsFavorite(courseId)
    }

    override suspend fun toggleFavoriteStatus(course: Course) {
        val isCurrentlyFavorite = favoritesDao.observeIsFavorite(course.id).first()

        if (isCurrentlyFavorite) {
            favoritesDao.removeFromFavorite(course.id)
        } else {
            favoritesDao.addToFavorite(course.toDbModel())
        }
    }
}