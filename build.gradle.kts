plugins {
    alias(libs.plugins.android.application.plugin).apply(false)
    alias(libs.plugins.android.library.plugin).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin).apply(false)
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods).apply(false)
}
