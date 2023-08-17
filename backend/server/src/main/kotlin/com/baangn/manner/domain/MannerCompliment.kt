package com.baangn.manner.domain

import javax.persistence.*

@Embeddable
class MannerCompliment(
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val type: ComplimentType,

    // TODO 추후 EAGER LAZY 비교
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    val complimentDetails : MutableList<ComplimentDetail> = mutableListOf()
)

