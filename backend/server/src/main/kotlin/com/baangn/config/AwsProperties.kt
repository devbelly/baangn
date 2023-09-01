package com.baangn.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "aws")
@ConstructorBinding
data class AwsProperties(
    val accessKey: String,
    val secretKey: String,
    val bucket: String,
    val region: String
)
