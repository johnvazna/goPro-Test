package com.johnvazna.stream_feature.data.network

import com.johnvazna.stream_feature.data.models.VideosDto
import retrofit2.http.GET

interface VideoApi {
    @GET("takehome-android.json")
    suspend fun getVideos(): VideosDto
}
