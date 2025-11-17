package ru.sumin.testtask.features.favorites.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.sumin.testtask.features.favorites.data.repository.FavoritesRepositoryImpl
import ru.sumin.testtask.features.favorites.domain.repository.FavoritesRepository
import ru.sumin.testtask.features.favorites.domain.usecase.GetFavoriteCoursesUseCase
import ru.sumin.testtask.features.favorites.domain.usecase.RemoveFavoriteUseCase // <-- ИМПОРТ
import ru.sumin.testtask.features.favorites.presentation.FavoritesViewModel

val favoritesModule = module {
    single<FavoritesRepository> { FavoritesRepositoryImpl(dao = get()) }
    factory { GetFavoriteCoursesUseCase(repository = get()) }
    factory { RemoveFavoriteUseCase(repository = get()) }

    viewModel {
        FavoritesViewModel(
            getCoursesUseCase = get(),
            removeFavoriteUseCase = get()
        )
    }
}