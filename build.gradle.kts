plugins {
    kotlin("jvm") version "1.4.31"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "net.seliba"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
}

dependencies {
    shadow("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
    implementation(kotlin("stdlib"))
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.shadowJar {
    val classifier : String? = null
    archiveClassifier.set(classifier)
}