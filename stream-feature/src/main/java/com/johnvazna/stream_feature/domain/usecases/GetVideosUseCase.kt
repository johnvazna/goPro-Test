package com.johnvazna.stream_feature.domain.usecases

import com.johnvazna.core.FlowUseCase
import com.johnvazna.stream_feature.data.VideoRepository
import com.johnvazna.stream_feature.domain.models.Video
import javax.inject.Inject

class GetVideosUseCase @Inject constructor(
    private val repository: VideoRepository
) : FlowUseCase<Unit, List<Video>>() {
    override suspend fun build(params: Unit): List<Video> =
        repository.fetchVideos()
}
