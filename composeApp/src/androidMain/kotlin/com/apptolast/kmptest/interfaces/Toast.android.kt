package com.apptolast.kmptest.interfaces

import android.widget.Toast
import com.apptolast.kmptest.MyApplication

actual fun toast(message: String, duration: ToastDuration) {
    val toastDuration = when (duration) {
        ToastDuration.SHORT -> Toast.LENGTH_SHORT
        ToastDuration.LONG -> Toast.LENGTH_SHORT
    }
    val context = MyApplication.getInstance().appContext
    Toast.makeText(context, message, toastDuration).show()
}