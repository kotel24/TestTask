package ru.sumin.testtask.features.home.data.mapper

import ru.sumin.testtask.core.database.model.FavoriteCourseDbModel
import ru.sumin.testtask.core.network.model.CourseDto
import ru.sumin.testtask.features.home.domain.entity.Course

fun CourseDto.toEntity(isFavorite: Boolean): Course {
    return Course(
        id = id,
        title = title,
        description = description,
        price = price,
        rate = rate,
        startDate = startDate,
        isFavorite = isFavorite,
        publishDate = publishDate
    )
}
fun Course.toDbModel(): FavoriteCourseDbModel {
    return FavoriteCourseDbModel(
        id = id,
        title = title,
        description = description,
        price = price,
        rate = rate,
        startDate = startDate,
        publishDate = publishDate
    )
}