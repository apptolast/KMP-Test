plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
}

group = "com.apptolast.kmptest"
version = "1.0.0"
application {
    mainClass.set("com.apptolast.kmptest.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)

    // Koin for Ktor
//    implementation(libs.koin.ktor)
    // SLF4J Logger
//    implementation(libs.koin.logger.slf4j)

    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}