package com.baangn.infra.kakao

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * TODO getProfileImage 동작확인하면 리팩토링
 * INFO
 * 중첩클래스를 만들기 위해 companion object를 사용하는 것은 잘못되었다!
 * 자바에서는 static 키워드를 사용해 중첩 클래스를 만들었지만
 * 코틀린에서는 아무런 키워드가 없이도 중첩 클래스를 만들 수 있다.
 */
class OAuthResponse {

    data class LoginResponse(
        val id: Long,
        var profileImage: String
    ) {
        @SuppressWarnings("unchecked")
        @JsonProperty("kakao_account")
        fun getProfileImage(kakaoAccount: Map<String, Any>) {
            val profile = kakaoAccount["profile"] as Map<String, String>
            profileImage = profile["thumbnail_image_url"] ?: ""
        }
    }

    data class LogoutResponse(
        val id: Long
    )
}