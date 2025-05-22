package com.johnvazna.stream_feature.data.models

import com.google.gson.annotations.SerializedName

data class VideosDto(
    @SerializedName("videos")
    val videos: List<VideoDto>
)
