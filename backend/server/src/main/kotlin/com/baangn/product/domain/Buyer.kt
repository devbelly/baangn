package com.baangn.product.domain

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Buyer(


    val id: Long,

    @Column(name = "buyer_name")
    val name: String
)
