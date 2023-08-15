package com.baangn.user.domain

import javax.persistence.*


@Entity
@Table
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    val oauthId: Long,

    @Column(length = 20)
    val nickname: String? = null,

    @Embedded
    val location: Location? = null,

    @Column(length = 250)
    val profileUrl: String? = null,
)


