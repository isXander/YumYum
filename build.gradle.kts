plugins {
    // Languages
    kotlin("jvm") version "1.5.31"
    java

    // Minecraft
    id("fabric-loom") version "0.9.+"
}

group = "dev.isxander"
version = "0.1"

repositories {
    mavenCentral()
    maven(url = "https://maven.fabricmc.net/")
}

dependencies {
    val minecraftVersion: String by project
    val yarnMappings: String by project
    val loaderVersion: String by project
    val fabricVersion: String by project
    val fabricKotlinVersion: String by project
    val kambrikVersion: String by project

    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings("net.fabricmc:yarn:$yarnMappings:v2")
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")
    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabricVersion")
    modImplementation("net.fabricmc:fabric-language-kotlin:$fabricKotlinVersion")
    modImplementation("io.ejekta:kambrik:$kambrikVersion")
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand("version" to project.version)
        }
    }

    compileJava {
        options.release.set(16)
    }
    compileKotlin {
        kotlinOptions {
            jvmTarget = "16"
        }
    }
}