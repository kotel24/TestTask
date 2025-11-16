package ru.sumin.testtask.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.sumin.testtask.features.home.domain.usecase.GetCoursesUseCase

class HomeViewModel(
    private val getCoursesUseCase: GetCoursesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    private var isSorted = false

    init {
        loadCourses()
    }

    private fun loadCourses() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, isError = false) }
            try {
                val courses = getCoursesUseCase(sortedByDate = isSorted)
                _state.update {
                    it.copy(isLoading = false, courses = courses)
                }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, isError = true) }
                e.printStackTrace()
            }
        }
    }

    fun onSortClicked() {
        isSorted = !isSorted
        loadCourses()
    }
}