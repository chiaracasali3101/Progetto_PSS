plugins {
    java
    application
    id("com.gradleup.shadow") version "8.3.5" // Plugin per creare un fat-jar
    id("org.danilopianini.gradle-java-qa") version "1.166.0"
}

project.extra.set("mainClassName", "persistence.ScoreManagerImpl")

group = "persistence"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral() 
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

application {
    mainClass.set("persistence.ScoreManagerImpl")

    (this as ExtensionAware).extra["mainClassName"] = "persistence.ScoreManagerImpl"
}

tasks.test {
    useJUnitPlatform() 
}

tasks.jar {
    enabled = false 
}

tasks.build {
    dependsOn("shadowJar") 
}

tasks.matching { it.name.contains("shadowDist") || it.name == "startShadowScripts" }.configureEach {
    enabled = false
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    manifest {
        attributes["Main-Class"] = "persistence.ScoreManagerImpl"
    }
}