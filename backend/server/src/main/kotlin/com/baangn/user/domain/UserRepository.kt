package com.baangn.user.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull

fun UserRepository.getUserById(id: Long): User = findByIdOrNull(id)
    ?: throw NoSuchElementException("회원이 존재하지 않습니다. id: $id")

interface UserRepository : JpaRepository<User, Long> {
    fun findByOauthId(oauthId: Long): User?
    fun existsByOauthId(oauthId: Long): Boolean
}
