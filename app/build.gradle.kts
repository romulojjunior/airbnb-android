plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.google.devtools.ksp")
    id ("com.google.dagger.hilt.android")
}

val composeVersion = "1.8.3"

android {
    namespace = "com.demo.airbnb"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.demo.airbnb"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        // testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunner = "com.demo.airbnb.CustomTestRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "HOST_URL", """"http://remotehost.com"""")
        }

        debug {
            isDebuggable = true
            buildConfigField("String", "HOST_URL", """"http://localhost:8080"""")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "META-INF/*"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.16.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.2")
    implementation("androidx.activity:activity-compose:1.10.1")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-graphics:$composeVersion")
    implementation("androidx.compose.material3:material3:1.3.2")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling-preview:${composeVersion}")

    implementation("androidx.navigation:navigation-compose:2.9.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.2")

    // Image Download
    implementation("io.coil-kt:coil-compose:2.5.0")

    // DI - Hilt https://developer.android.com/training/dependency-injection/hilt-testing
    implementation("com.google.dagger:hilt-android:2.56.2")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.56.2")
    ksp("com.google.dagger:hilt-compiler:2.56.2")

    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.test.ext:junit:1.3.0")

    androidTestImplementation("androidx.test.ext:junit:1.3.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
}