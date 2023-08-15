package com.baangn.category

import com.support.domain.BaseEntity
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class Category(
    @Enumerated(EnumType.STRING)
    val type: ProductCategory,
    id: Long = 0L
) : BaseEntity(id)