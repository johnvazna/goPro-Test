package com.johnvazna.stream_feature.data.models

import com.google.gson.annotations.SerializedName

data class VideoDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("url")
    val url: String
)
