plugins {
    id("application")
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(libs.guava)
    implementation("org.springframework:spring-context:6.2.11")
    implementation("org.springframework:spring-aspects:6.2.11")
    implementation("org.aspectj:aspectjweaver:1.9.24")
    implementation("com.h2database:h2:2.4.240")
    implementation("org.springframework.data:spring-data-jdbc:3.5.4")
    implementation("org.springframework:spring-jdbc:6.2.11")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("co.edu.itc.programacion.biblioteca.ServicioBibliotec")
}

tasks.test {
    useJUnitPlatform()
}