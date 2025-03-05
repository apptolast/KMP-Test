package com.apptolast.kmptest.interfaces.version

actual class Version {
    actual val version: String = "Java ${System.getProperty("java.version")}"
}