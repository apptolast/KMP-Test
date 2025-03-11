package com.apptolast.kmptest.interfaces.version

import android.os.Build

actual class Version {
    actual val version: String = "Android ${Build.VERSION.SDK_INT}"
}
