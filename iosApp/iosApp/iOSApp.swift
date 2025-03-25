import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
//        ComposeApp.InitKoin_IosKt.doInitKoinIos()
//        InitKoin_iosKt.doInitKoinIos()
        KoinKt.doInitKoinIos()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

//__attribute__((objc_subclassing_restricted))
//__attribute__((swift_name("InitKoinKt")))
//@interface ComposeAppInitKoinKt : ComposeAppBase
//+ (void)doInitKoinAppDeclaration:(void (^)(ComposeAppKoin_coreKoinApplication *))appDeclaration __attribute__((swift_name("doInitKoin(appDeclaration:)")));
//@end


//__attribute__((objc_subclassing_restricted))
//__attribute__((swift_name("InitKoin_iosKt")))
//@interface ComposeAppInitKoin_iosKt : ComposeAppBase
//+ (void)doInitKoinIos __attribute__((swift_name("doInitKoinIos()")));
//@property (class, readonly) ComposeAppKoin_coreModule *nativeModule __attribute__((swift_name("nativeModule")));
//@end
