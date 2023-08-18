package com.baangn.user.application

import com.baangn.security.JwtTokenProvider
import com.baangn.user.domain.UserSelector
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class UserAuthenticationService(
    private val userSelector: UserSelector,
    private val jwtTokenProvider: JwtTokenProvider
) {
    fun login(oauthId: Long): String {
        check(userSelector.existsByOAuthId(oauthId)) { "회원이 존재하지 않습니다. oauthId: $oauthId" }
        return jwtTokenProvider.createToken(oauthId.toString())
    }


}
