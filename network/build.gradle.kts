plugins {
    id("android-library-convention")
    id("hilt-convention")
}

android {
    namespace = "com.johnvazna.network"
}

dependencies {
    implementation(project(":core"))

    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiAdapter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.loggingInterceptor)
    implementation(Dependencies.coroutines)
}