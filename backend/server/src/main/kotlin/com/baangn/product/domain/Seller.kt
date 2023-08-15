package com.baangn.product.domain

import javax.persistence.AttributeOverride
import javax.persistence.AttributeOverrides
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Seller(

    @AttributeOverrides(
        AttributeOverride(name = "id", column = Column(name = "seller_id"))
    )
    val id: Long,
)
