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
