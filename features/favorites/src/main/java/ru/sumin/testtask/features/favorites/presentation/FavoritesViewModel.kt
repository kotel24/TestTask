package ru.sumin.testtask.features.favorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.sumin.testtask.features.favorites.domain.entity.Course
import ru.sumin.testtask.features.favorites.domain.usecase.GetFavoriteCoursesUseCase
import ru.sumin.testtask.features.favorites.domain.usecase.RemoveFavoriteUseCase

class FavoritesViewModel(
    getCoursesUseCase: GetFavoriteCoursesUseCase,
    private val removeFavoriteUseCase: RemoveFavoriteUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(FavoritesState(isLoading = true))
    val state = _state.asStateFlow()

    init {
        getCoursesUseCase()
            .onEach { courses ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        courses = courses
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun onFavoriteClicked(course: Course) {
        viewModelScope.launch {
            removeFavoriteUseCase(course)
        }
    }
}