import com.android.build.gradle.internal.dsl.BaseAppModuleExtension

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

configure<BaseAppModuleExtension> {
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    "implementation"(Dependencies.coreKtx)
    "implementation"(Dependencies.lifecycle)
    "implementation"(Dependencies.activityCompose)

    val composeBom = platform(Dependencies.composeBom)
    "implementation"(composeBom)
    "androidTestImplementation"(composeBom)

    "implementation"(Dependencies.composeUi)
    "implementation"(Dependencies.composeUiGraphics)
    "implementation"(Dependencies.composeMaterial3)
    "implementation"(Dependencies.composePreview)

    "testImplementation"(Dependencies.junit)
    "androidTestImplementation"(Dependencies.androidJunit)
    "androidTestImplementation"(Dependencies.espresso)
    "androidTestImplementation"(Dependencies.composeTestJunit4)

    "debugImplementation"("androidx.compose.ui:ui-tooling")
    "debugImplementation"("androidx.compose.ui:ui-test-manifest")
}