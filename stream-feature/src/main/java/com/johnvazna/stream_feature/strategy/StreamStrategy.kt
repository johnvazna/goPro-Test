package com.johnvazna.stream_feature.strategy

import android.view.Surface

interface StreamStrategy {
    fun prepare(url: String)
    fun play(surface: Surface)
    fun release()
}
