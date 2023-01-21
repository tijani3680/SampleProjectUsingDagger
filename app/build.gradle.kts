import dependencies.AndroidTestDependencies
import dependencies.Dependencies
import dependencies.TestDependencies

plugins {
    id(Plugins.ANDROID_APPLICATION)
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation(Dependencies.APP_COMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAIN_LAYOUT)

    // Navigation Component
    implementation(Dependencies.NAVIGATION_COMPONENT_FRAGMENT)
    implementation(Dependencies.NAVIGATION_COMPONENT_UI)
    implementation(Dependencies.NAVIGATION_COMPONENT_DYNAMIC_FEATURES)

    // Coroutines
    implementation(Dependencies.COROUTINES_CORE)
    implementation(Dependencies.COROUTINES)

    // Data store
    implementation(Dependencies.DATA_STORE)


    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")

    // Retrofit

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.7.2")

    // Room db
    implementation("androidx.room:room-runtime:${Versions.ROOM}")
    implementation("androidx.room:room-ktx:${Versions.ROOM}")
    annotationProcessor("androidx.room:room-compiler:${Versions.ROOM}")
    kapt("androidx.room:room-compiler:${Versions.ROOM}")


    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(AndroidTestDependencies.EXT_JUNIT)
    androidTestImplementation(AndroidTestDependencies.ESPRESSO)
}
