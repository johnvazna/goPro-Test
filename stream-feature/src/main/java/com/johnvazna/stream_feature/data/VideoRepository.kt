package com.johnvazna.stream_feature.data

import com.johnvazna.stream_feature.domain.models.Video

interface VideoRepository {
    suspend fun fetchVideos(): List<Video>
}
