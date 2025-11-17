package ru.sumin.testtask.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_courses")
data class FavoriteCourseDbModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val publishDate: String,
)