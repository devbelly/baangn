package com.baangn.user.domain

import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import org.springframework.stereotype.Component

@Component
class UserSelector(
    private val factory : SpringDataQueryFactory,
    private val repository : UserRepository
){
    fun findByOAuthId(oauthId : Long) = repository.findByOAuthId(oauthId)
    fun existsByOAuthId(oauthId : Long) = repository.existsByOAuthId(oauthId)
}
