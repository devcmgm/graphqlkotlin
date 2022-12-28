import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.github.kobylynskyi.graphql.codegen.gradle.*

plugins {
	id("org.springframework.boot") version "3.0.1"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.jpa") version "1.7.22"
	id("io.github.kobylynskyi.graphql.codegen") version "5.5.0"


}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
// https://mavenlibs.com/maven/dependency/com.graphql-java-kickstart/graphql-java-tools
	implementation("com.graphql-java-kickstart:graphql-java-tools:13.0.2")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-graphql")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")

	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:15.0.0")
	implementation ("com.graphql-java-kickstart:graphiql-spring-boot-starter:11.0.0")
	implementation ("com.graphql-java:graphql-java-extended-scalars:16.0.1")

	// testing facilities
	testImplementation("com.graphql-java-kickstart:graphql-spring-boot-starter-test:15.0.0")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework:spring-webflux")
	testImplementation("org.springframework.graphql:spring-graphql-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.named<GraphQLCodegenGradleTask>("graphqlCodegen") {
	// all config options:
	// https://github.com/kobylynskyi/graphql-java-codegen/blob/master/docs/codegen-options.md
	graphqlSchemaPaths = listOf("$projectDir/src/main/resources/graphql/schema.graphqls")
	outputDir = File("$buildDir/generated")
	packageName = "com.example.graphql.model"
	customTypesMapping = mutableMapOf(Pair("EpochMillis", "java.time.LocalDateTime"))
	customAnnotationsMapping = mutableMapOf(Pair("EpochMillis", listOf("@com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.example.json.EpochMillisScalarDeserializer.class)")))
}

// Automatically generate GraphQL code on project build:
sourceSets {
	getByName("main").java.srcDirs("$buildDir/generated")
}

// Add generated sources to your project source sets:
tasks.named<JavaCompile>("compileJava") {
	dependsOn("graphqlCodegen")
}
