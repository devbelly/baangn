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

data class UserResponse(
    val id: Long,
    val oauthId: Long,
    val nickname: String,
    val profileUrl: String?
){
    constructor(user: User) : this(
        user.id,
        user.oauthId,
        user.nickname,
        user.profileUrl
    )
}