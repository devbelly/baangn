package com.baangn.manner.domain

import com.support.domain.BaseRootEntity
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.Entity

@Entity
class Manner(
    @Column(nullable = false)
    val userId: Long,

    @Column(nullable = false)
    val evaluatorId: Long,

    @Column(nullable = false)
    val productId: Long,

    compliment: MannerCompliment = MannerCompliment(),
    id: Long = 0L
) : BaseRootEntity<Manner>(id) {

    @Embedded
    var compliment: MannerCompliment = compliment
        private set

    val degree: Double
        get() = compliment.type.point

    /**
     * save 시에 이벤트가 발행된다.
     */
    init {
        registerEvent(MannerCreatedEvent(userId, degree))
    }
}
