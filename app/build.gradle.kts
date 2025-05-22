plugins {
    id("android-application-convention")
    id("hilt-convention")
}

android {
    namespace = "com.johnvazna.goprotest"

    defaultConfig {
        applicationId = "com.johnvazna.goprotest"
        versionCode = 1
        versionName = "1.0.0"
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":network"))
    implementation(project(":stream-feature"))

    implementation(Dependencies.hiltNavigation)
    implementation(Dependencies.composeNavigation)
}
