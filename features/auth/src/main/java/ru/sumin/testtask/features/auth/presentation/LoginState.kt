package ru.sumin.testtask.features.auth.presentation

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoginEnabled: Boolean = false
)