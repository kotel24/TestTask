package ru.sumin.testtask.features.home.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sumin.testtask.features.home.domain.entity.Course

interface CoursesRepository {
    suspend fun getCourses(sortedByDate: Boolean): List<Course>

    fun observeIsFavorite(courseId: Int): Flow<Boolean>

    suspend fun toggleFavoriteStatus(course: Course)
}