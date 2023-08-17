@Suppress("DSL_SCOPE_VIOLATION")
plugins{
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.boot.io.management)

    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)

    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
}

dependencies{
    implementation(libs.jackson.kotlin)
    implementation(libs.kotlin.reflect)

    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.data.kotlin.jdsl.starter)
    implementation(libs.spring.boot.starter.web)
    runtimeOnly(libs.mysql)

    implementation(libs.coroutines.reactor)
    implementation(libs.coroutines.jdk8)

    implementation(libs.bundles.feign)
    implementation(libs.bundles.jwt)

    // https://mvnrepository.com/artifact/javax.validation/validation-api
    implementation("javax.validation:validation-api:2.0.1.Final")

    kapt(libs.spring.boot.configuration.processor)
}