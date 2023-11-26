plugins {
	java
        // war //sin este, lo corre el servidor
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.Cuei"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
	mavenCentral()
}

dependencies {
        compileOnly("org.projectlombok:lombok")
        annotationProcessor("org.projectlombok:lombok")

        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
        implementation("org.springframework.boot:spring-boot-starter-web")
        // https://mvnrepository.com/artifact/joda-time/joda-time
        implementation("joda-time:joda-time:2.12.5")
        implementation("org.springframework.cloud:spring-cloud-gcp-starter-sql-mysql:1.2.8.RELEASE")

	runtimeOnly("com.mysql:mysql-connector-j")
	//providedRuntime("org.springframework.boot:spring-boot-starter-tomcat") //asi lo corre el servidor
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
