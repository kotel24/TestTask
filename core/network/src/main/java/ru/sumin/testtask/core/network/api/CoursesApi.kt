package ru.sumin.testtask.core.network.api

import retrofit2.http.GET
import ru.sumin.testtask.core.network.model.CoursesResponse

interface CoursesApi {

    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    suspend fun loadCourses(): CoursesResponse
}