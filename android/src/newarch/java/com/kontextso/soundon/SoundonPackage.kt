package com.kontextso.soundon

import com.facebook.react.BaseReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class SoundonPackage : BaseReactPackage() {
  override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? {
    return if (name == SoundonModule.NAME) {
      SoundonModule(reactContext)
    } else {
      null
    }
  }

  override fun getReactModuleInfoProvider(): ReactModuleInfoProvider {
    return ReactModuleInfoProvider {
      mapOf(
        SoundonModule.NAME to ReactModuleInfo(
          SoundonModule.NAME,
          SoundonModule.NAME,
          false,  // canOverrideExistingModule
          false,  // needsEagerInit
          false,  // isCxxModule
          true    // isTurboModule
        )
      )
    }
  }
}
