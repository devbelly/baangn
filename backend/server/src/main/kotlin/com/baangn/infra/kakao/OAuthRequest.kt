package com.baangn.infra.kakao

class OAuthRequest {
    data class LoginRequest(
        val accessToken: String
    )

    data class LogoutRequest(
        val accessToken: String
    )
}