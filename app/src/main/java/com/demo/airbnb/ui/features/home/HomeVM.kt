package com.demo.airbnb.ui.features.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.airbnb.domain.entities.PlaceCategory
import com.demo.airbnb.domain.usecases.places.IGetPlacesCategoriesUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val getPlacesCategoriesUC: IGetPlacesCategoriesUC
) : ViewModel() {
    data class UIState(
        val exception: Exception? = null,
        val isLoading: Boolean = false,
        val placeCategories: List<PlaceCategory> = emptyList()
    )

    private val _uiState = mutableStateOf(UIState())
    val uiState = _uiState

    init {
        getPlaceCategories()
    }

    private fun getPlaceCategories() {
        _uiState.value = _uiState.value.copy(isLoading = true, exception = null)

        viewModelScope.launch(Dispatchers.IO) {
            val placeCategories = getPlacesCategoriesUC.execute()
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                placeCategories = placeCategories
            )
        }
    }
}