// Top-level build.gradle.kts

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false

    // ✅ Add Compose compiler plugin here for Kotlin 2.0+
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false
}
