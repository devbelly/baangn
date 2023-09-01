package com.baangn.config

import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.services.s3.S3Client
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(AwsProperties::class)
class S3Configuration(private val awsProperties: AwsProperties) {
    @Bean
    fun s3Client() = S3Client {
        region = awsProperties.region
        credentialsProvider = StaticCredentialsProvider {
            accessKeyId = awsProperties.accessKey
            secretAccessKey = awsProperties.secretKey
        }
    }
}