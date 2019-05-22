import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

buildscript {
    repositories {
        google()
        jcenter()
        maven("https://dl.bintray.com/jetbrains/kotlin-native-dependencies")
    }
}

plugins {
    kotlin("jvm") version "1.3.31"
    id("org.jlleitschuh.gradle.ktlint") version "8.0.0"
}

version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

configurations {
    ktlint
}

dependencies {
    compile(kotlin("stdlib"))
    ktlint("com.pinterest:ktlint:0.32.0")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testImplementation("org.mockito:mockito-core:2.27.0")
    testImplementation("org.assertj:assertj-core:3.12.2")
    testImplementation("com.google.guava:guava-testlib:27.1-jre")

    // Remove once Mockito 3.x gets released with Junit 5 support
    testImplementation("org.mockito:mockito-junit-jupiter:2.27.0")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
    // Enable JUnit 5 (Gradle 4.6+).
    useJUnitPlatform()

    // Always run tests, even when nothing changed.
    dependsOn("cleanTest")

    // Show test results.
    testLogging {
        events("passed", "skipped", "failed")
    }
}

ktlint {
    verbose.set(true)
    outputToConsole.set(true)
    coloredOutput.set(true)
    reporters.set(setOf(ReporterType.CHECKSTYLE, ReporterType.JSON))
    filter {
        exclude("**/style-violations.kt")
    }
}
