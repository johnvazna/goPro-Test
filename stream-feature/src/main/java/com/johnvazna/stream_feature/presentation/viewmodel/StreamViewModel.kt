package com.johnvazna.stream_feature.presentation.viewmodel

import com.johnvazna.core.BaseViewModel
import com.johnvazna.core.Result
import com.johnvazna.stream_feature.domain.models.Video
import com.johnvazna.stream_feature.domain.usecases.GetVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StreamViewModel @Inject constructor(
    private val getVideosUseCase: GetVideosUseCase
) : BaseViewModel() {

    private val _videosState = createResultState<List<Video>>()
    val videosState: StateFlow<Result<List<Video>>> = _videosState.asStateFlow()

    init {
        loadVideos()
    }

    private fun loadVideos() {
        executeUseCase(
            useCase = { getVideosUseCase(Unit) },
            stateFlow = _videosState
        )
    }

    fun refresh() {
        loadVideos()
    }
}
