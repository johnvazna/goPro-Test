import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("org.jetbrains.kotlin.plugin.compose")
}

configure<LibraryExtension> {
    buildFeatures {
        compose = true
    }
}

dependencies {
    val composeBom = platform(Dependencies.composeBom)
    "implementation"(composeBom)
    "androidTestImplementation"(composeBom)

    "implementation"(Dependencies.composeUi)
    "implementation"(Dependencies.composeMaterial3)
    "implementation"(Dependencies.composePreview)
    "implementation"(Dependencies.activityCompose)

    "debugImplementation"("androidx.compose.ui:ui-tooling")
    "debugImplementation"("androidx.compose.ui:ui-test-manifest")
}