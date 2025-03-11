package com.apptolast.kmptest.interfaces

enum class ToastDuration {
    SHORT,
    LONG
}

expect fun toast(message: String, duration: ToastDuration = ToastDuration.SHORT)
