package com.apptolast.kmptest.interfaces.version

class Greeting {

    fun greet(): String {
        return "Hello, ${Version().version}!"
    }
}