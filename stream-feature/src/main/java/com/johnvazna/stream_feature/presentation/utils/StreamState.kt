package com.johnvazna.stream_feature.presentation.utils

sealed class StreamState {
    object Idle : StreamState()
    object Preparing : StreamState()
    object Ready : StreamState()
    object Playing : StreamState()
    data class Error(val message: String) : StreamState()
}

val StreamState.isLoading: Boolean
    get() = this is StreamState.Preparing

val StreamState.isStreaming: Boolean
    get() = this != StreamState.Idle
