package com.apptolast.kmptest.interfaces

import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication

actual fun toast(message: String, duration: ToastDuration) {
    println("Toast: $message")
    showAlert("Toast", message)
}

fun showAlert(title: String, message: String) {
    val alertController = UIAlertController.alertControllerWithTitle(
        title = title,
        message = message,
        preferredStyle = UIAlertControllerStyleAlert
    )

    alertController.addAction(
        UIAlertAction.actionWithTitle(
            title = "OK",
            style = UIAlertActionStyleDefault,
            handler = null
        )
    )

    // Obtain the main window and show the alert
    val keyWindow = UIApplication.sharedApplication.keyWindow
    val rootViewController = keyWindow?.rootViewController
    rootViewController?.presentViewController(alertController, animated = true, completion = null)
}