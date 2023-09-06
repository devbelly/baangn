package com.baangn.user.ui

import com.baangn.RestControllerTest
import com.baangn.createRegisterUserRequest
import com.baangn.infra.kakao.KakaoFeignClient
import com.baangn.infra.kakao.OAuthResponse
import com.baangn.infra.presigner.PresignerUtils
import com.baangn.user.application.UserAuthenticationService
import com.baangn.user.application.UserService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.post

@WebMvcTest(UserController::class)
class UserControllerTest : RestControllerTest() {
    @MockkBean
    private lateinit var userService: UserService

    @MockkBean
    private lateinit var userAuthenticationService: UserAuthenticationService

    @MockkBean
    private lateinit var kakaoFeignClient: KakaoFeignClient

    @MockkBean
    private lateinit var presignerUtils: PresignerUtils

    @Test
    fun `올바른 회원가입 요청에 NoContent를 반환한다`() {
        val oauthResponse = OAuthResponse(id = 1L, profileImage = "test.png")
        every { kakaoFeignClient.getUserInfo(any()) } returns oauthResponse
        every { userService.create(any()) } returns 1L

        mockMvc.post("/api/users/register") {
            jsonContent(createRegisterUserRequest())
        }.andExpect {
            status { isNoContent() }
        }
    }
}