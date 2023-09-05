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

tasks {
	val copySecret by register<Copy>("copySecret") {
		from("./baangn-submodule") // 서브모듈 디렉토리 경로
		include("application*.yml") // 복사할 파일들
		into("./server/src/main/resources") // 복사 위치
	}

	named("processResources") {
		dependsOn(copySecret)
	}
}