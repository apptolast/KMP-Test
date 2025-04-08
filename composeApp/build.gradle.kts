
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.gradleBuildConfig)
    alias(libs.plugins.kotzilla)
}

kotlin {
    androidTarget {
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

//        all {
//            languageSettings.enableLanguageFeature("ExplicitBackingFields")
//        }

        androidMain.dependencies {
            implementation(compose.preview)

            // Androidx
            implementation(libs.bundles.androidx.android)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(libs.androidx.lifecycle.viewmodel)

            implementation(compose.runtime)
            implementation(compose.foundation)
//            implementation(compose.material3)
            implementation(libs.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)


            // Androidx
            implementation(libs.bundles.androidx.common)

            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.androidx.navigation.compose)

            // Koin
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
//            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)

            // The Kotzilla SDK library dependency
            implementation(libs.kotzilla.sdk)

            implementation(projects.shared)
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
        versionName = "0.1.0"
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

    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
}

buildConfig {
    packageName("com.apptolast.kmptest")
    val properties = Properties()
    properties.load(project.rootProject.file("local.properties").reader())
    val testApiKey = properties.getProperty("TEST_API_KEY")
    val kotzillaApiKey = properties.getProperty("TEST_API_KEY")

    buildConfigField("TEST_API_KEY", testApiKey)
    buildConfigField("KOTZILLA_API_KEY", kotzillaApiKey)
}