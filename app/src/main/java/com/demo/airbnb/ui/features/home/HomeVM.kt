package com.demo.airbnb.ui.features.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.demo.airbnb.ui.features.login.LoginVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor() : ViewModel() {
    data class UIState(
        val exception: Exception? = null,
        val isLoading: Boolean = false
    )

    private val _uiState = mutableStateOf(LoginVM.UIState())
    val uiState = _uiState
}