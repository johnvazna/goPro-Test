import org.gradle.kotlin.dsl.dependencies

plugins {
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

dependencies {
    "implementation"(Dependencies.hilt)
    "kapt"(Dependencies.hiltCompiler)

    "testImplementation"("com.google.dagger:hilt-android-testing:${Versions.hilt}")
    "kaptTest"(Dependencies.hiltCompiler)

    "androidTestImplementation"("com.google.dagger:hilt-android-testing:${Versions.hilt}")
    "kaptAndroidTest"(Dependencies.hiltCompiler)
}

kapt {
    correctErrorTypes = true
}