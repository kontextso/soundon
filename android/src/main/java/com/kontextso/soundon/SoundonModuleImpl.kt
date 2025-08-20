package com.kontextso.soundon

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import android.content.Context
import android.media.AudioManager

class SoundonModuleImpl(private val reactContext: ReactApplicationContext) {
  fun isSoundOn(promise: Promise?) {
    val audioManager = reactContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    val current = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
    val max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
    val volume = if (max > 0) current.toFloat() / max.toFloat() else 0f

    promise?.resolve(volume > MINIMAL_VOLUME_THRESHOLD)
  }

  companion object {
    private const val MINIMAL_VOLUME_THRESHOLD = 0.0f
  }
}
