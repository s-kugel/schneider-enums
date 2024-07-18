import com.s_kugel.schneider.generator.enums.EnumGeneratorTask

plugins {
    `java-library`
    idea
    eclipse
    `maven-publish`
    alias(libs.plugins.spotless)
    id("com.s-kugel.schneider.plugin.enum-generator") version("1.0.0")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.lombok)
    annotationProcessor(libs.lombok)
    testImplementation(libs.lombok)
    testAnnotationProcessor(libs.lombok)
}

java {
    sourceCompatibility = JavaVersion.toVersion("21")
    targetCompatibility = JavaVersion.toVersion("21")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

spotless {
    encoding("UTF-8")
    java {
        importOrder()
        formatAnnotations()
        indentWithSpaces()
        removeUnusedImports()
        trimTrailingWhitespace()
        endWithNewline()
        googleJavaFormat()
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.s-kugel.schneider"
            artifactId = "enums"
            version = "1.0.0"
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
    }
}

tasks.register<EnumGeneratorTask>("generateEuleEnum") {
    url = "jdbc:mysql://${System.getenv("EULE_DB_HOST")}:${System.getenv("EULE_DB_PORT")}/${System.getenv("EULE_DB_NAME")}"
    user = System.getenv("EULE_DB_USER")
    password = System.getenv("EULE_DB_PASSWORD")
    tables = listOf("Authority", "StaffStatus")
    packageName = "com.s_kugel.schneider.enums"
    outDir = "${projectDir.path}/src/main/java"
}

tasks.register<EnumGeneratorTask>("generateFasanEnum") {
    url = "jdbc:mysql://${System.getenv("FASAN_DB_HOST")}:${System.getenv("FASAN_DB_PORT")}/${System.getenv("FASAN_DB_NAME")}"
    user = System.getenv("FASAN_DB_USER")
    password = System.getenv("FASAN_DB_PASSWORD")
    tables = listOf()
    packageName = "com.s_kugel.schneider.enums"
    outDir = "${projectDir.path}/src/main/java"
}
