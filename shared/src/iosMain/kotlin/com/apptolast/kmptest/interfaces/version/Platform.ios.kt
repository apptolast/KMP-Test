package com.apptolast.kmptest.interfaces.version

import platform.UIKit.UIDevice

actual class Version {
    actual val version: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}