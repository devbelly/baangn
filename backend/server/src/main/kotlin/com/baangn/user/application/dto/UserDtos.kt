package com.baangn.user.application.dto

import com.baangn.user.domain.User
import javax.validation.constraints.NotBlank

data class RegisterUserRequest(
    @field:NotBlank
    val accessToken: String
)

data class LoginUserRequest(
    @field:NotBlank
    val accessToken: String
)

/**
 * 현재 당근마켓에 프로필 수정을 누르면 닉네임과 프로필이미지 변경이 가능하다
 */
data class EditUserRequest(
    val nickname: String,
    val profileUrl: String?
)

data class UserResponse(
    val id: Long,
    val oauthId: Long,
    val nickname: String,
    var profileUrl: String?
){
    constructor(user: User) : this(
        user.id,
        user.oauthId,
        user.nickname,
        user.profileUrl
    )
}