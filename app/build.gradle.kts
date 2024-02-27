buildscript {
    repositories {
        google()
        mavenCentral()
    }
}


plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.dagger.hilt.android")

   // kotlin("plugin.serialization")version "1.9.0"
}

android {
    namespace = "com.javierpastor.sharesave"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.javierpastor.sharesave"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8

    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //HILT

    implementation("com.google.dagger:hilt-android:2.46")
    kapt("com.google.dagger:hilt-android-compiler:2.46")
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")

    implementation ("com.google.dagger:hilt-android:2.40.5")
    kapt ("com.google.dagger:hilt-android-compiler:2.40.5")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    implementation ( "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07")


    //NavHost: navegador entre pantallas
    val nav_version = "2.5.3"

    implementation("androidx.navigation:navigation-compose:$nav_version")

    //ICONS EXTENDED
    implementation("androidx.compose.material:material-icons-extended:1.6.1")

    //ROOM
    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:2.6.1")


    //lifecycle
    implementation ("androidx.compose.runtime:runtime-livedata:1.1.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    //ksp("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.13")
    //ksp("com.google.devtools.ksp:symbol-processing:1.9.0-1.0.13")


//    implementation("androidx.room:room-runtime:$room_version")
//    annotationProcessor("androidx.room:room-compiler:$room_version")
//    // To use Kotlin Symbol Processing (KSP)
//    kapt("androidx.room:room-compiler:$room_version")
//    implementation("androidx.room:room-ktx:2.6.1")
//
//    ksp("com.google.devtools.ksp:symbol-processing-api:1.9.0-1.0.13")
//    ksp("com.google.devtools.ksp:symbol-processing:1.9.0-1.0.13")


    //SharedPreferences y DataStore

    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // optional - RxJava2 support
    implementation("androidx.datastore:datastore-preferences-rxjava2:1.0.0")

    // optional - RxJava3 support
    implementation("androidx.datastore:datastore-preferences-rxjava3:1.0.0")

    implementation("androidx.datastore:datastore-preferences-core:1.0.0")
    implementation("androidx.datastore:datastore-core:1.0.0")




}
kapt {
    correctErrorTypes = true
}