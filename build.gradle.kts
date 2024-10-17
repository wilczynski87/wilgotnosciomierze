plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	kotlin("plugin.serialization") version "1.5.31"
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.mokrosc"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.18.0")
	// https://mvnrepository.com/artifact/com.azure/azure-storage-blob
	implementation("com.azure:azure-storage-blob:12.28.0")
	// https://mvnrepository.com/artifact/com.azure/azure-storage-common
	implementation("com.azure:azure-storage-common:12.27.0")
	// https://mvnrepository.com/artifact/com.azure/azure-identity
	implementation("com.azure:azure-identity:1.13.3")
	implementation("com.google.code.gson:gson:2.8.9")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")



	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.github.wimdeblauwe:htmx-spring-boot-thymeleaf:3.5.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
