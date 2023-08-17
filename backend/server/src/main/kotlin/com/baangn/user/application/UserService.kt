package com.baangn.user.application

import com.baangn.user.domain.User
import com.baangn.user.domain.UserRepository
import com.baangn.user.domain.UserSelector
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class UserService(
    private val userSelector: UserSelector
    private val userRepository: UserRepository
) {

    fun create(oauthId: Long){
        check(!userSelector.existsByOAuthId(oauthId)) { "이미 가입된 회원입니다. oauthId: $oauthId" }

        userRepository.save(User(oauthId))
    }

    fun getByOauthId(oauthId: Long): User{
        return userSelector.findByOAuthId(oauthId) ?: throw IllegalArgumentException("회원이 존재하지 않습니다. oauthId: $oauthId")
    }


}