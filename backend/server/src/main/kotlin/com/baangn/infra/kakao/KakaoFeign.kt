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
    @RequestLine("GET $LOGIN_PATH")
    fun getUserInfo(
        @Param("accessToken") accessToken: String
    ): OAuthResponse.LoginResponse

    @Headers(value = ["Authorization: Bearer {accessToken}"])
    @RequestLine("POST $LOGOUT_PATH")
    fun logout(
        @Param("accessToken") accessToken: String
    ): OAuthResponse.LogoutResponse
}

@Component
class KakaoFeignClient(
    private val kakaoFeign: KakaoFeign
) {
    fun getUserInfo(loginRequest: OAuthRequest.LoginRequest): OAuthResponse.LoginResponse =
        kakaoFeign.getUserInfo(loginRequest.accessToken)
}
