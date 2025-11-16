package ru.sumin.testtask.core.network.model

import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses")
    val courses: List<CourseDto>
)