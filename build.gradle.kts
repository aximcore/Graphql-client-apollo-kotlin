plugins {
    kotlin("jvm") version "1.3.72"

    id("com.apollographql.apollo").version("2.2.1")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7")
    implementation(kotlin("stdlib-jdk8"))
    // The core runtime dependencies
    implementation("com.apollographql.apollo:apollo-runtime:2.2.1")
    // Coroutines extensions for easier asynchronicity handling
    implementation("com.apollographql.apollo:apollo-coroutines-support:2.2.1")
}

apollo {
    // instruct the compiler to generate Kotlin models
    generateKotlinModels.set(true)
    rootPackageName.set("me.axim")
    // graphqlSourceDirectorySet.srcDir("src/main/kotlin/me/axim/graphql")
    // graphqlSourceDirectorySet.include("**/*.graphql")
    // graphqlSourceDirectorySet.exclude("**/schema.graphql")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}