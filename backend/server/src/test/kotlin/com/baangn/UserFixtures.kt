package com.baangn

import com.baangn.user.application.dto.RegisterUserRequest
import com.baangn.user.domain.Location
import com.baangn.user.domain.User

const val OAUTH_ID: Long = 123456789
const val NICKNAME: String = "사용자"
const val PROFILE_URL: String = "test.png"
val LOCATION: Location = Location("서울시 송파구")

const val VALID_ACCESS_TOKEN ="valid_access_token"

fun createUser(
    oauthId: Long = OAUTH_ID,
    nickname: String = NICKNAME,
    location: Location = LOCATION,
    profileUrl: String = PROFILE_URL,
    id: Long = 0L
): User {
    return User(oauthId, nickname, location, profileUrl, id)
}

fun createRegisterUserRequest(
    accessToken: String = VALID_ACCESS_TOKEN
): RegisterUserRequest {
    return RegisterUserRequest(accessToken)
}

