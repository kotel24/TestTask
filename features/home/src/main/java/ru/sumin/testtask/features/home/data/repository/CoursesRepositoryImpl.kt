package ru.sumin.testtask.features.home.data.repository

import ru.sumin.testtask.core.network.api.CoursesApi
import ru.sumin.testtask.features.home.data.mapper.toEntity
import ru.sumin.testtask.features.home.domain.entity.Course
import ru.sumin.testtask.features.home.domain.repository.CoursesRepository

class CoursesRepositoryImpl(
    private val api: CoursesApi
) : CoursesRepository {

    private var cachedCourses: List<Course> = emptyList()

    override suspend fun getCourses(sortedByDate: Boolean): List<Course> {
        if (cachedCourses.isEmpty()) {
            val response = api.loadCourses()
            cachedCourses = response.courses.map { it.toEntity() }
        }

        return if (sortedByDate) {
            cachedCourses.sortedByDescending { it.publishDate }
        } else {
            cachedCourses
        }
    }
}