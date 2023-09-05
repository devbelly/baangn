package com.baangn.infra.kakao

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotBlank

data class OAuthLoginRequest(
    @field:NotBlank
    val accessToken: String
)

data class OAuthLogoutRequest(
    @field:NotBlank
    val accessToken: String
)

data class OAuthResponse(
    val id: Long,
    var profileImage: String?
) {
    @SuppressWarnings("unchecked")
    @JsonProperty("kakao_account")
    fun getProfileImage(kakaoAccount: Map<String, Any>) {
        val profile = kakaoAccount["profile"] as Map<String, String>
        profileImage = profile["thumbnail_image_url"] ?: ""
        println("profileImage: $profileImage")
    }
}