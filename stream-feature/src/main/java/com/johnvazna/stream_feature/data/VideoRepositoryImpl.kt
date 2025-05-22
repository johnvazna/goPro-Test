package com.johnvazna.stream_feature.data

import com.johnvazna.stream_feature.data.mapper.VideoMapper
import com.johnvazna.stream_feature.data.network.VideoApi
import com.johnvazna.stream_feature.domain.models.Video
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val api: VideoApi
) : VideoRepository {
    override suspend fun fetchVideos(): List<Video> =
        VideoMapper.fromList(api.getVideos().videos)
}
