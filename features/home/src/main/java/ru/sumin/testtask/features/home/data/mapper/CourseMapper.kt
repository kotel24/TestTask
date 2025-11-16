package ru.sumin.testtask.features.home.data.mapper

import ru.sumin.testtask.core.network.model.CourseDto
import ru.sumin.testtask.features.home.domain.entity.Course

fun CourseDto.toEntity(): Course {
    return Course(
        id = id,
        title = title,
        description = description,
        price = price,
        rate = rate,
        startDate = startDate,
        isFavorite = hasLike,
        publishDate = publishDate
    )
}