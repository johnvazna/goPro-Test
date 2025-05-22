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
}