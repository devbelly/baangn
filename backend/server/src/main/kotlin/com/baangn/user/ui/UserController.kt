package com.baangn.user.ui

import com.baangn.infra.kakao.KakaoFeignClient
import com.baangn.infra.kakao.OAuthLogoutRequest
import com.baangn.infra.presigner.PresignerUtils
import com.baangn.security.LoginUser
import com.baangn.user.application.UserAuthenticationService
import com.baangn.user.application.UserService
import com.baangn.user.application.dto.EditUserRequest
import com.baangn.user.application.dto.LoginUserRequest
import com.baangn.user.application.dto.RegisterUserRequest
import com.baangn.user.application.dto.UserResponse
import com.baangn.user.domain.User
import com.support.ui.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/api/users")
@RestController
class UserController(
    private val userService: UserService,
    private val userAuthenticationService: UserAuthenticationService,
    private val kakaoFeignClient: KakaoFeignClient,
    private val presignerUtils: PresignerUtils,
) {
    /**
     * 회원가입 시 JWT 토큰은 돌려줄 필요가 없다.
     */
    @PostMapping("/register")
    fun register(@RequestBody @Valid request: RegisterUserRequest): ResponseEntity<Unit> {
        val oauthId = kakaoFeignClient.getUserInfo(request.accessToken).id
        userService.create(oauthId)
        return ResponseEntity.noContent().build()
    }

    /**
     * 로그인 시 JWT 토큰을 발급한다.
     */
    @PostMapping("/login")
    fun login(@RequestBody @Valid request: LoginUserRequest): ResponseEntity<ApiResponse<String>> {
        val oauthId = kakaoFeignClient.getUserInfo(request.accessToken).id
        return ResponseEntity.ok(ApiResponse.success(userAuthenticationService.login(oauthId)))
    }

    @PostMapping("/logout")
    fun logout(@RequestBody @Valid request: OAuthLogoutRequest): ResponseEntity<Unit> {
        kakaoFeignClient.logout(request.accessToken)
        return ResponseEntity.noContent().build()
    }

    @PutMapping("/information")
    fun editInformation(
        @RequestBody @Valid request: EditUserRequest,
        @LoginUser user: User
    ): ResponseEntity<Unit> {
        userService.edit(user.id, request)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/me")
    suspend fun getMyInformation(@LoginUser user: User): ResponseEntity<ApiResponse<UserResponse>> {
        val response = userService.getUserInformation(user.id)
            .apply { profileUrl = profileUrl?.let { presignerUtils.getProfilePresignedGetUrl(it) } }
        return ResponseEntity.ok(ApiResponse.success(response))
    }

    @GetMapping("/{userId}")
    suspend fun getUserInformation(@PathVariable userId: Long): ResponseEntity<ApiResponse<UserResponse>> {
        val response = userService.getUserInformation(userId)
            .apply { profileUrl = profileUrl?.let { presignerUtils.getProfilePresignedGetUrl(it) } }
        return ResponseEntity.ok(ApiResponse.success(response))
    }
}