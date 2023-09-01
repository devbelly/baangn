package com.baangn.user.application

import com.baangn.user.application.dto.EditUserRequest
import com.baangn.user.application.dto.UserResponse
import com.baangn.user.domain.User
import com.baangn.user.domain.UserRepository
import com.baangn.user.domain.UserSelector
import com.baangn.user.domain.getUserById
import org.apache.commons.io.FilenameUtils
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class UserService(
    private val userSelector: UserSelector,
    private val userRepository: UserRepository
) {

    fun create(oauthId: Long): Long {
        check(!userSelector.existsByOAuthId(oauthId)) { "이미 가입된 회원입니다. oauthId: $oauthId" }

        return userRepository.save(User(oauthId)).id
    }

    fun edit(userId: Long, editUserRequest: EditUserRequest) {
        val user = userRepository.getUserById(userId)

        editUserRequest.nickname
            .takeIf { it.isNotBlank() }
            ?.let { user.changeNickname(it) }


        FilenameUtils.getName(editUserRequest.profileUrl?.let { "$userId/$it" } ?: "")
            .takeIf { it.isNotBlank() }
            ?.let { user.changeProfileUrl(it) }
    }


    fun getByOauthId(oauthId: Long): User {
        return userSelector.findByOAuthId(oauthId) ?: throw IllegalArgumentException("회원이 존재하지 않습니다. oauthId: $oauthId")
    }

    fun getUserInformation(id: Long): UserResponse{
        val user = userRepository.getUserById(id)
        return UserResponse(user)
    }



}