package com.apptolast.kmptest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform