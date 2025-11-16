package ru.sumin.testtask.features.home.domain.repository

import ru.sumin.testtask.features.home.domain.entity.Course

interface CoursesRepository {
    suspend fun getCourses(sortedByDate: Boolean): List<Course>
}