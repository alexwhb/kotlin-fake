plugins {
    kotlin("multiplatform") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
    id("maven-publish")
}
group = "com.blackstone"
version = "0.1.5"

repositories {
    gradlePluginPortal()
    google()
    maven ("https://dl.bintray.com/korlibs/korlibs" )
    mavenCentral()
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    ios()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("net.mamoe.yamlkt:yamlkt:0.12.0")
                implementation("com.soywiz.korlibs.krypto:krypto:2.4.12")
                implementation( "com.benasher44:uuid:0.4.0")
                implementation("com.soywiz.korlibs.klock:klock:2.4.13")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2")
            }

        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
//        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val iosMain by getting {}
        val iosTest by getting {}
//
//        val jsMain by getting

        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Test by getting {
            dependsOn(iosTest)
        }

    }
}

publishing {
    // this fetches our credentials from ~/.gradle/gradle.properties
    val mavenUser: String? by project
    val mavenPassword: String? by project

    repositories {
        maven {
            setUrl("https://repos.awhb.dev/releases")
            authentication {
                create("basic", BasicAuthentication::class.java)
            }
            credentials {
                username = mavenUser
                password = mavenPassword
            }
        }
    }
}
