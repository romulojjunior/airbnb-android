package com.demo.airbnb.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.airbnb.domain.entities.PlaceCategory
import com.demo.airbnb.domain.usecases.places.IGetPlacesCategoriesUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    private val _uiState = MutableStateFlow(UIState())
    val uiState = _uiState.asStateFlow()

    init {
        getPlaceCategories()
    }

    private fun getPlaceCategories() {
        _uiState.update {
            it.copy(isLoading = true, exception = null)
        }

        viewModelScope.launch(Dispatchers.IO) {
            val placeCategories = getPlacesCategoriesUC.execute()
            _uiState.update {
                it.copy(
                    isLoading = false,
                    placeCategories = placeCategories
                )
            }
        }
    }
}