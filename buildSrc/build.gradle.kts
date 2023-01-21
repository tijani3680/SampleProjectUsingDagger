repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation("com.android.tools.build:gradle:7.2.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.6.1")
    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.4.2")

}
