plugins {
    alias(libs.plugins.android.application.plugin)
    alias(libs.plugins.kotlin.android.plugin)

    alias(libs.plugins.jetbrains.compose.multiplatform.plugin)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.moko.mobile.multiplatform.resources)
}

android {
    namespace = "com.determent.outlet2.android"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.determent.outlet2.android"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.version.get()
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    // Google
    implementation(libs.androidx.activity.compose)

    // Jetbrains
    implementation(libs.jetbrains.kotlinx.coroutines.android)

    // Project Module
    implementation(projects.shared)

    // Google
    implementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.tooling)
}