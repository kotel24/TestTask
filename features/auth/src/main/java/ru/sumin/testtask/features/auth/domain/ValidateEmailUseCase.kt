package ru.sumin.testtask.features.auth.domain

class ValidateEmailUseCase {

    private val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$")

    operator fun invoke(email: String): Boolean {
        return emailRegex.matches(email)
    }
}