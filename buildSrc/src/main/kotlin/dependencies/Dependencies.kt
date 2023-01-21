package dependencies

object Dependencies {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CONSTRAIN_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAIN_LAYOUT}"
    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER}"
    const val DAGGER_ANDROID = "com.google.dagger:dagger-android:${Versions.DAGGER}"
    const val DAGGER_ANDROID_SUPPORT = "com.google.dagger:dagger-android-support:${Versions.DAGGER}"

    const val INJECT = "javax.inject:javax.inject:${Versions.INJECT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"

    const val NAVIGATION_COMPONENT_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_COMPONENT}"
    const val NAVIGATION_COMPONENT_UI= "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_COMPONENT}"
    const val NAVIGATION_COMPONENT_DYNAMIC_FEATURES= "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION_COMPONENT}"
    const val COROUTINES_CORE= "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES= "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val DATA_STORE= "androidx.datastore:datastore-preferences:${Versions.DATA_STORE}"
}
