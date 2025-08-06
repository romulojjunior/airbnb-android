package com.demo.airbnb.ui.features.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.airbnb.domain.entities.Session
import com.demo.airbnb.domain.usecases.account.ISignInUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(private val signInUC: ISignInUC) : ViewModel() {
    data class UIState(
        val session: Session? = null,
        val exception: Exception? = null,
        val isLoading: Boolean = false
    )

    private val _state: MutableStateFlow<UIState> = MutableStateFlow(UIState())
    val state: StateFlow<UIState> = _state.asStateFlow()

    fun signIn(email: String, password: String) {
        _state.update {
            it.copy(isLoading = true, exception = null)
        }

        try {
            viewModelScope.launch(Dispatchers.IO) {
                val session = signInUC.execute(email, password)
                _state.update {
                    it.copy(
                        session = session,
                        isLoading = false
                    )
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            _state.update {
                it.copy(
                    exception = e,
                    isLoading = false
                )
            }
        }
    }
}