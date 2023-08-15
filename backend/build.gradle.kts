import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.kapt)
}

group = "com.baangn"
version = "0.0.1-SNAPSHOT"

allprojects{
	repositories {
		mavenCentral()
	}

	tasks{
		withType<KotlinCompile> {
			kotlinOptions {
				freeCompilerArgs = listOf("-Xjsr305=strict")
				jvmTarget = "19"
			}
		}
	}
}

subprojects{
	apply(plugin="kotlin")

	tasks.withType<Test>{
		useJUnitPlatform()
	}
}