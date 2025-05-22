package com.johnvazna.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UIState>(private val initial: UIState) : ViewModel() {

    private val _uiState = MutableStateFlow(initial)
    val uiState: StateFlow<UIState> = _uiState

    protected fun <T> launchUseCase(
        block: suspend () -> Result<T>,
        reducer: (Result<T>) -> UIState
    ) {
        viewModelScope.launch {
            _uiState.value = reducer(Result.Loading)
            val result = block()
            _uiState.value = reducer(result)
        }
    }
}
