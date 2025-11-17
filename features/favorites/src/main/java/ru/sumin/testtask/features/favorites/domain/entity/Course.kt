package ru.sumin.testtask.features.favorites.domain.entity

data class Course(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val rate: String,
    val startDate: String,
    val isFavorite: Boolean,
    val publishDate: String
)