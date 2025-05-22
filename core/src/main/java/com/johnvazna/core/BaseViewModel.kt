package com.johnvazna.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseViewModel : ViewModel() {

    protected fun <T> executeUseCase(
        useCase: () -> Flow<Result<T>>,
        stateFlow: MutableStateFlow<Result<T>>
    ) {
        useCase()
            .onEach { result -> stateFlow.value = result }
            .launchIn(viewModelScope)
    }

    protected fun <T> createResultState(
        initialValue: Result<T> = Result.Loading
    ): MutableStateFlow<Result<T>> {
        return MutableStateFlow(initialValue)
    }
}
