package com.demo.airbnb.ui.features.placedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.airbnb.domain.entities.Place
import com.demo.airbnb.domain.usecases.places.GetPlacesByIdUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceDetailsVM @Inject constructor(private val getPlacesByIdUC: GetPlacesByIdUC) : ViewModel() {
    data class UIState(
        val exception: Exception? = null,
        val isLoading: Boolean = false,
        val place: Place? = null
    )

    private val _uiState = MutableStateFlow(UIState())
    val uiState = _uiState.asStateFlow()

    fun loadPlace(id: Int) {
        _uiState.update {
            it.copy(isLoading = true, exception = null)
        }
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val place = getPlacesByIdUC.execute(id)
                _uiState.update {
                    it.copy(place = place,  isLoading = false)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            _uiState.update {
                it.copy(exception = e, isLoading = false)
            }
        }
    }
}