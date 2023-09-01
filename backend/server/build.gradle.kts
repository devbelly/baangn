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
    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation("org.apache.commons:commons-lang3:3.0")
    // https://mvnrepository.com/artifact/commons-io/commons-io
    implementation("commons-io:commons-io:2.11.0")

    implementation("aws.sdk.kotlin:s3-jvm:0.26.0-beta")
    implementation("org.apache.logging.log4j:log4j-slf4j2-impl:2.20.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("aws.smithy.kotlin:aws-signing-crt:0.21.0")
    kapt(libs.spring.boot.configuration.processor)
}