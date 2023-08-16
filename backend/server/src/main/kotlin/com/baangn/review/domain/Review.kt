package com.baangn.review.domain

import javax.persistence.Column
import javax.persistence.Entity


@Entity
class Review(
    @Column(nullable = false)
    val reviewerId : Long,

    @Column(nullable = false)
    val revieweeId : Long,

    @Column(nullable=false)
    val productId: Long,
)
