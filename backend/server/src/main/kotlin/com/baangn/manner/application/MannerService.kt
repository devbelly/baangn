package com.baangn.manner.application

import com.baangn.manner.application.dto.CreateMannerRequest
import com.baangn.manner.domain.Manner
import com.baangn.manner.domain.MannerRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Transactional
@Service
class MannerService(
    private val mannerRepository: MannerRepository
) {

    fun create(userId: Long, request: CreateMannerRequest) {
        mannerRepository.save(
            Manner(
                userId = userId,
                evaluatorId = request.evaluatorId,
                productId = request.productId,
                compliment = request.mannerCompliment
            )
        )
    }
}