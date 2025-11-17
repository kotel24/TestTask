package ru.sumin.testtask.features.home.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.sumin.testtask.features.home.data.repository.CoursesRepositoryImpl
import ru.sumin.testtask.features.home.domain.repository.CoursesRepository
import ru.sumin.testtask.features.home.domain.usecase.GetCoursesUseCase
import ru.sumin.testtask.features.home.domain.usecase.ToggleFavoriteUseCase
import ru.sumin.testtask.features.home.presentation.HomeViewModel

val homeModule = module {

    single<CoursesRepository> {
        CoursesRepositoryImpl(
            api = get(),
            favoritesDao = get()
        )
    }

    factory { GetCoursesUseCase(repository = get()) }
    factory { ToggleFavoriteUseCase(repository = get()) }

    viewModel {
        HomeViewModel(
            getCoursesUseCase = get(),
            toggleFavoriteUseCase = get()
        )
    }
}