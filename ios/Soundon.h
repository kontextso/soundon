#import "Soundon-Swift.h"

#ifdef RCT_NEW_ARCH_ENABLED
#import <SoundonSpec/SoundonSpec.h>

@interface Soundon: NSObject <NativeSoundonSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Soundon: NSObject <RCTBridgeModule>
#endif

@end
