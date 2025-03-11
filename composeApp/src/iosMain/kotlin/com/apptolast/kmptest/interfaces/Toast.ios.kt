package com.apptolast.kmptest.interfaces

actual fun toast(message: String, duration: ToastDuration) {
    println("Toast: $message")
//    let alert = UIAlertController (title: nil, message: message, preferredStyle: .alert)
//    UIApplication.shared.keyWindow?.rootViewController?.present(alert, animated: true)
}