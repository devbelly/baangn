package com.baangn.user.application.dto

import javax.validation.constraints.NotBlank

data class RegisterUserRequest(
    @field:NotBlank
    val accessToken: String
)

data class LoginUserRequest(
    @field:NotBlank
    val accessToken: String
)