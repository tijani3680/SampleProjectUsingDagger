import com.diffplug.gradle.spotless.SpotlessExtensionPredeclare

plugins {
    id(Plugins.SPOTLESS)
}

configure<SpotlessExtensionPredeclare> {
    kotlin { ktlint(Versions.KTLINT) }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
