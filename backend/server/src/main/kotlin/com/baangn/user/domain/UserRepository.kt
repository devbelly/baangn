package com.baangn.user.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByOAuthId(oauthId: Long): User?
    fun existsByOAuthId(oauthId: Long): Boolean
}