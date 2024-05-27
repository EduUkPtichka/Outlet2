plugins {
    alias(libs.plugins.android.library.plugin)
    alias(libs.plugins.jetbrains.compose.multiplatform.plugin)
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin)
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods.plugin)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)

    alias(libs.plugins.touchlab.skie.plugin)
    alias(libs.plugins.moko.mobile.multiplatform.resources)

    // kotlin-parcelize
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "15.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            //isStatic = true

            export(libs.moko.resources)
            export(libs.moko.graphics)

            export(libs.arkivanov.decompose)
            export(libs.arkivanov.essenty.lifecycle)
            export(libs.arkivanov.essenty.stateKeeper)
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            // Compose Multiplatform
            api(libs.jetbrains.composeRuntime)
            api(libs.jetbrains.composeFoundation)
            api(libs.jetbrains.composeMaterial3)
            api(libs.jetbrains.composeMaterial)
            api(libs.jetbrains.composeUi)

            // Jetbrains
            implementation(libs.jetbrains.kotlinx.coroutines.core)
            implementation(libs.jetbrains.kotlinxCollectionsImmutable)

            implementation(libs.jetbrains.kotlinx.serialization.json)

            // Jetbrains Ktor-Client
            implementation(libs.ktor.client.core)

            // Kodein
            implementation(libs.kodein.di)

            // Moko
            api(libs.moko.resources)
            api(libs.moko.resourcesCompose)

            // Decompose
            implementation(libs.arkivanov.decompose)
            implementation(libs.arkivanov.decompose.extensionsCompose)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)

            implementation(libs.compose.ui.tooling.preview)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "com.determent.outlet2"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.version.get()
    }

    buildFeatures {
        compose = true
    }

    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

multiplatformResources {
    resourcesPackage.set("determent.outlet.moko_resources")
}

