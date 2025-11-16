package ru.sumin.testtask.features.auth.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.sumin.testtask.features.auth.domain.ValidateEmailUseCase

class LoginViewModel(
    private val validateEmailUseCase: ValidateEmailUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onEmailChange(newValue: String) {
        _state.update { it.copy(email = newValue) }
        validate()
    }

    fun onPasswordChange(newValue: String) {
        _state.update { it.copy(password = newValue) }
        validate()
    }

    private fun validate() {
        val email = _state.value.email
        val password = _state.value.password

        val isEmailValid = validateEmailUseCase(email)
        val isPasswordValid = password.isNotEmpty()

        _state.update {
            it.copy(isLoginEnabled = isEmailValid && isPasswordValid)
        }
    }
}