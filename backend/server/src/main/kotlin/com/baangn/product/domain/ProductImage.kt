package com.baangn.product.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ProductImage(
    @Column(nullable = false)
    val url: String
)