plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 19
        multiDexEnabled = true
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:22.1.2")
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.9")
//    implementation("com.google.firebase:firebase-database:20.2.2")
//    implementation("com.google.firebase:firebase-firestore:24.8.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.afollestad:sectioned-recyclerview:0.2.3")
    implementation("com.intuit.sdp:sdp-android:1.1.0")
    implementation("com.hbb20:ccp:2.5.0")
    implementation("com.android.support:multidex:2.0.1")

    // PHONE PE INTEGRATION//
//    implementation ("com.phonepe.android.sdk:phonepesdk:1.0.0")
//    implementation ("phonepe.intentsdk.android.release:IntentSDK:2.3.0")
//    implementation ("phonepe.intentsdk.android.snapshot:IntentSDK:releaseSDK-1229827-SNAPSHOT")
//    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
//    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
}