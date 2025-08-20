#import "Soundon.h"
#import "Soundon-Swift.h"

@implementation Soundon

RCT_EXPORT_MODULE()

#ifdef RCT_NEW_ARCH_ENABLED
- (void)isSoundOn:(RCTPromiseResolveBlock)resolve
           reject:(RCTPromiseRejectBlock)reject {
    NSNumber *isSoundOn = [AudioUtility isSoundOn];

    if (isSoundOn == nil) {
        reject(@"soundon_error", @"Failed to read output volume", nil);
    } else {
        resolve(isSoundOn);
    }
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params {
    return std::make_shared<facebook::react::NativeSoundonSpecJSI>(params);
}
#else
RCT_EXPORT_METHOD(isSoundOn : (RCTPromiseResolveBlock)
                      resolve rejecter : (RCTPromiseRejectBlock)reject) {
    NSNumber *isSoundOn = [AudioUtility isSoundOn];

    if (isSoundOn == nil) {
        reject(@"soundon_error", @"Failed to read output volume", nil);
    } else {
        resolve(isSoundOn);
    }
}
#endif

@end
