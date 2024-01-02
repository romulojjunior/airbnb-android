package com.demo.airbnb.ui.features.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.demo.airbnb.domain.entities.PlaceCategory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor() : ViewModel() {
    data class UIState(
        val exception: Exception? = null,
        val isLoading: Boolean = false,
        val placeCategories: List<PlaceCategory> = emptyList()
    )

    private val _uiState = mutableStateOf(UIState())
    val uiState = _uiState

    init {
        _uiState.value = _uiState.value.copy(
            isLoading = false,
            placeCategories = listOf(
                PlaceCategory(id = 1, priority = 0, name = "Home"),
                PlaceCategory(id = 2, priority = 1, name = "Call"),
                PlaceCategory(id = 3, priority = 2, name = "Face"),
                PlaceCategory(id = 4, priority = 3, name = "Info"),
            )
        )
    }
}