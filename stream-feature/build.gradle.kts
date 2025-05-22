plugins {
    id("android-library-convention")
    id("compose-convention")
    id("hilt-convention")
}

android {
    namespace = "com.johnvazna.stream_feature"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":network"))

    implementation(Dependencies.exoplayer)
    implementation(Dependencies.exoplayerHls)
    implementation(Dependencies.exoplayerUi)

    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
}