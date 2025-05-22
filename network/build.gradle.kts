plugins {
    id("android-library-convention")
    id("hilt-convention")
}

android {
    namespace = "com.johnvazna.network"
}

dependencies {
    implementation(project(":core"))

    api(Dependencies.retrofit)
    api(Dependencies.moshi)
    api(Dependencies.moshiAdapter)
    api(Dependencies.okHttp)
    api(Dependencies.loggingInterceptor)
    api(Dependencies.coroutines)
}