package ru.sumin.testtask.features.favorites.data.mapper

import ru.sumin.testtask.core.database.model.FavoriteCourseDbModel
import ru.sumin.testtask.features.favorites.domain.entity.Course

fun FavoriteCourseDbModel.toEntity(): Course {
    return Course(
        id = id,
        title = title,
        description = description,
        price = price,
        rate = rate,
        startDate = startDate,
        isFavorite = true,
        publishDate = publishDate
    )
}