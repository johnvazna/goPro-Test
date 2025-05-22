plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    //noinspection UseTomlInstead,AndroidGradlePluginVersion
    implementation("com.android.tools.build:gradle:8.8.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:2.0.0")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
}