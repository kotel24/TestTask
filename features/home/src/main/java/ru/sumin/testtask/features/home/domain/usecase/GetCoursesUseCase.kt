package ru.sumin.testtask.features.home.domain.usecase

import ru.sumin.testtask.features.home.domain.entity.Course
import ru.sumin.testtask.features.home.domain.repository.CoursesRepository

class GetCoursesUseCase(
    private val repository: CoursesRepository
) {
    suspend operator fun invoke(sortedByDate: Boolean = false): List<Course> {
        return repository.getCourses(sortedByDate)
    }
}