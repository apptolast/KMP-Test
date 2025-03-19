import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(compose.preview)

            // Androidx
            implementation(libs.bundles.androidx.android)
            implementation(libs.androidx.lifecycle.viewmodel)

            // Koin
//            implementation(libs.koin.android)
//            implementation(libs.koin.androidx.compose)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            // Androidx
            implementation(libs.bundles.androidx.common)

            implementation(libs.androidx.lifecycle.runtime.compose)

            // Koin
//            implementation(libs.koin.compose)
//            implementation(libs.koin.compose.viewmodel)
//            implementation(libs.koin.core)
//            implementation(libs.koin.androidx.startup)



            implementation(projects.shared)

            // Navigation - Voyager
            implementation(libs.bundles.voyager)
        }
    }

//    task("testClasses")
}

android {
    namespace = "com.apptolast.kmptest"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.apptolast.kmptest"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(libs.compose.ui.tooling)
}

//El problema es que la dependencia koin-compose-viewmodel está diseñada específicamente para Android Compose. Si bien puedes usarla en el módulo androidMain, no es la dependencia correcta para usar en commonMain que tambien la estas usando.
//viewModelOf está disponible en koin-core, pero solo funciona cuando se inyecta de manera manual a un módulo, no funciona de manera directa para asociarlo a una clase viewModel como lo quieres hacer.

