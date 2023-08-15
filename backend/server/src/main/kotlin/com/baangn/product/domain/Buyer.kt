package com.baangn.product.domain

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Buyer(

    @AttributeOverrides(
        AttributeOverride(name = "id", column = Column(name = "buyer_id"))
    )
    val id: Long,

    @Column(name = "buyer_name")
    val name: String
)
