plugins {
    kotlin("multiplatform") version "1.4.0"
    kotlin("plugin.serialization") version "1.4.0"
}
group = "com.blackstone"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven(
        "https://dl.bintray.com/suparnatural/kotlin-multiplatform"
    )
}
kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    val klock_version = "1.12.0"
    val fs_version = "1.0.10"

    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")
    val nativeTarget = when {
        hostOs == "Mac OS X" -> macosX64("native")
        hostOs == "Linux" -> linuxX64("native")
        isMingwX64 -> mingwX64("native")
        else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("suparnatural-kotlin-multiplatform:fs-metadata:$fs_version")
                implementation("net.mamoe.yamlkt:yamlkt:0.5.1")

                implementation("com.soywiz.korlibs.krypto:krypto:1.12.0")

                implementation( "com.benasher44:uuid:0.2.2")
                implementation("com.soywiz.korlibs.klock:klock:$klock_version")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC")
            }

        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("suparnatural-kotlin-multiplatform:fs-jvm:$fs_version")
                implementation("com.soywiz.korlibs.klock:klock-jvm:$klock_version")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }

        val nativeMain by getting
        val nativeTest by getting
    }
}