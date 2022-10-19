plugins {
	id("java")
}

group = "com.toastcoders"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.apache.directory.studio:org.dom4j.dom4j:1.6.1")
	implementation("log4j:log4j:1.2.17")
	implementation("org.apache.httpcomponents:httpclient:4.3.5")
	compileOnly("org.projectlombok:lombok:1.16.6")
	testImplementation("javax.servlet:javax.servlet-api:3.1.0")
	testImplementation("junit:junit-dep:4.11")
	testImplementation("junit:junit:4.12")
	testImplementation("org.spockframework:spock-core:0.7-groovy-2.0")
	testImplementation("cglib:cglib-nodep:3.1")
	testImplementation("org.objenesis:objenesis:2.1")

	annotationProcessor("org.projectlombok:lombok:1.16.6")
}

tasks.getByName<Test>("test") {
	useJUnitPlatform()
}