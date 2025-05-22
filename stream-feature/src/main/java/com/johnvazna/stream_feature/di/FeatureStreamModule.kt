package com.johnvazna.stream_feature.di

import com.johnvazna.stream_feature.data.VideoRepository
import com.johnvazna.stream_feature.data.VideoRepositoryImpl
import com.johnvazna.stream_feature.data.network.VideoApi
import com.johnvazna.stream_feature.domain.usecases.GetVideosUseCase
import com.johnvazna.stream_feature.strategy.StreamStrategy
import com.johnvazna.stream_feature.strategy.StreamStrategyManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FeatureStreamModule {
    @Binds
    @Singleton
    abstract fun bindVideoRepository(impl: VideoRepositoryImpl): VideoRepository

    @Binds
    @Singleton
    abstract fun bindGetVideosUseCase(impl: GetVideosUseCase): GetVideosUseCase

    @Binds
    @Singleton
    abstract fun bindStreamStrategy(impl: StreamStrategyManager): StreamStrategy

    companion object {
        @Provides
        @Singleton
        fun provideVideoApi(retrofit: Retrofit): VideoApi = retrofit.create(VideoApi::class.java)
    }
}
