package com.kontextso.soundon

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import android.content.Context
import android.media.AudioManager

class SoundonModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  private val impl = SoundonModuleImpl(reactContext)

  override fun getName(): String = NAME

  @ReactMethod
  fun isSoundOn(promise: Promise?) {
    impl.isSoundOn(promise)
  }

  companion object {
    const val NAME = "Soundon"
  }
}
