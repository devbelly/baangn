package com.baangn.manner.domain

import com.support.domain.BaseEntity
import com.support.domain.BaseRootEntity
import javax.persistence.*

@Entity
class Manner(
    @Column(nullable = false)
    val userId: Long,

    @Column(nullable = false)
    val evaluatorId: Long,

    @Column(nullable = false)
    val productId: Long,

    compliment: MannerCompliment = MannerCompliment(),
    id :Long = 0L
): BaseEntity(id){

    @Embedded
    var compliment : MannerCompliment = compliment
        private set

    val degree : Double
        get() = compliment.type.point
}
