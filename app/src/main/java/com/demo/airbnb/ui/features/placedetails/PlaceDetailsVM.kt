package com.demo.airbnb.ui.features.placedetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.airbnb.domain.entities.Place
import com.demo.airbnb.domain.usecases.places.GetPlacesByIdUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceDetailsVM @Inject constructor(private val getPlacesByIdUC: GetPlacesByIdUC) : ViewModel() {
    data class UIState(
        val exception: Exception? = null,
        val isLoading: Boolean = false,
        val place: Place? = null
    )

    private val _uiState = mutableStateOf(UIState())
    val uiState = _uiState

    fun loadPlace(id: Int) {
        _uiState.value = _uiState.value.copy(isLoading = true, exception = null)
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val place = getPlacesByIdUC.execute(id)
                _uiState.value = _uiState.value.copy(place = place, isLoading = false)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            _uiState.value = _uiState.value.copy(exception = e, isLoading = false)
        }
    }
}