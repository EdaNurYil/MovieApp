plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.example.movieapp"
    compileSdk = 35



    defaultConfig {
        applicationId = "com.example.movieapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", "\"c1423cbe9000f7b40a2aefa9a7e8cc28\"")

        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"") // at the / i am not sure if it is correct or not
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
        dataBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //lifecyle dependeny
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.1")
    //view model
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.1")
    //annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:2.8.1")
    //save data state
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.8.1")


// Room core library
    implementation("androidx.room:room-runtime:2.6.1")

// Room Kotlin extensions and coroutines support
    implementation("androidx.room:room-ktx:2.6.1")

// Room annotation processor for Kotlin
    kapt("androidx.room:room-compiler:2.6.1")

    // Core coroutines library (general use)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

// Android-specific coroutine support (Main, IO dispatchers, etc.)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Dagger core library
    implementation("com.google.dagger:dagger:2.48")

// Dagger annotation processor for Kotlin
    kapt("com.google.dagger:dagger-compiler:2.48")


    // Retrofit core
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

// JSON converter using Gson
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// Optional: OkHttp Logging Interceptor (for logging network calls)
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation("com.google.code.gson:gson:2.10.1")

    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")

}