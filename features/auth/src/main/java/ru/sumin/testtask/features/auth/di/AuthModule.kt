package ru.sumin.testtask.features.auth.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.sumin.testtask.features.auth.domain.ValidateEmailUseCase
import ru.sumin.testtask.features.auth.presentation.LoginViewModel

val authModule = module {
    // Регистрируем UseCase как фабрику (создается каждый раз при запросе)
    factory { ValidateEmailUseCase() }

    // Передаем UseCase во ViewModel
    viewModel { LoginViewModel(validateEmailUseCase = get()) }
}