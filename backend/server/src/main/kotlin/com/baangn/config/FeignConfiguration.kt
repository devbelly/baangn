package com.baangn.config

import com.baangn.infra.kakao.KakaoFeign
import com.fasterxml.jackson.databind.ObjectMapper
import feign.Feign
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import feign.okhttp.OkHttpClient
import feign.slf4j.Slf4jLogger
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * TODO 나중에 option 추가하기
 */

@Configuration
@EnableConfigurationProperties(OAuthProperties::class)
class FeignConfiguration {

    @Bean
    fun kakaoOAuthClient(mapper: ObjectMapper, properties: OAuthProperties): KakaoFeign =
        Feign.builder()
            .client(OkHttpClient())
            .encoder(JacksonEncoder(mapper))
            .decoder(JacksonDecoder(mapper))
            .logger(Slf4jLogger())
            .target(KakaoFeign::class.java, properties.baseUrl)
}