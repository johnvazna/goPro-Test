package com.johnvazna.stream_feature.data.network

import com.johnvazna.stream_feature.data.models.VideoDto
import retrofit2.http.GET

interface VideoApi {
    @GET("takehome-android.json")
    suspend fun getVideos(): List<VideoDto>
}
