package com.baangn.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "oauth.kakao")
@ConstructorBinding
data class OAuthProperties(
    val baseUrl: String
)