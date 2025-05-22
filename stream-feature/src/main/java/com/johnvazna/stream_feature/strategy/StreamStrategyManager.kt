package com.johnvazna.stream_feature.strategy

import android.content.Context
import android.view.Surface
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StreamStrategyManager @Inject constructor(
    @ApplicationContext private val context: Context
) : StreamStrategy {
    private var player: ExoPlayer? = null
    override fun prepare(url: String) {
        player = ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(url)); prepare()
        }
    }

    override fun play(surface: Surface) {
        player?.setVideoSurface(surface)
        player?.playWhenReady = true
    }

    override fun release() {
        player?.release(); player = null
    }
}
