package com.baangn.infra.kakao

import feign.Headers
import feign.Param
import feign.RequestLine
import org.springframework.stereotype.Component


interface KakaoFeign {
    companion object {
        const val LOGIN_PATH = "/v2/user/me"
        const val LOGOUT_PATH = "/v1/user/logout"
    }

    @Headers(value = ["Authorization: Bearer {accessToken}"])
    @RequestLine("POST $LOGIN_PATH")
    fun getUserInfo(
        @Param("accessToken") accessToken: String
    ): OAuthResponse

    @Headers(value = ["Authorization: Bearer {accessToken}"])
    @RequestLine("POST $LOGOUT_PATH")
    fun logout(
        @Param("accessToken") accessToken: String
    ): Unit
}

@Component
class KakaoFeignClient(
    private val kakaoFeign: KakaoFeign
) {
    fun getUserInfo(accessToken: String): OAuthResponse =
        kakaoFeign.getUserInfo(accessToken)

    fun logout(accessToken: String): Unit =
        kakaoFeign.logout(accessToken)
}
