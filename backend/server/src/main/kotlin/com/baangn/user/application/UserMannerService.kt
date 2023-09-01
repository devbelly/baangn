package com.baangn.user.application

import com.baangn.manner.domain.MannerCreatedEvent
import com.baangn.user.domain.UserRepository
import com.baangn.user.domain.getUserById
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener


@Transactional
@Service
class UserMannerService(
    private val userRepository: UserRepository
) {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener
    fun manner(event: MannerCreatedEvent){
        val user = userRepository.getUserById(event.userId)
        user.evaluateManner(event.degree)
    }
}