package com.kontextso.soundon

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.fbreact.specs.NativeSoundonSpec
import com.facebook.react.bridge.Promise
import android.content.Context
import android.media.AudioManager

@ReactModule(name = SoundonModule.NAME)
class SoundonModule(reactContext: ReactApplicationContext) :
  NativeSoundonSpec(reactContext) {

  private val impl = SoundonModuleImpl(reactContext)

  override fun getName(): String = NAME

  override fun isSoundOn(promise: Promise?) {
    impl.isSoundOn(promise)
  }

  companion object {
    const val NAME = "Soundon"
  }
}
