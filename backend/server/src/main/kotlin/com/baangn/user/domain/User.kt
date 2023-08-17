package com.baangn.user.domain

import com.support.domain.BaseEntity
import javax.persistence.*


@Entity
@Table
class User(
    @Column(nullable = false)
    val oauthId: Long,

    nickname: String = "익명",

    location: Location? = null,

    @Column(length = 250)
    val profileUrl: String? = null,
    id : Long = 0L
):BaseEntity(id){

    @Column(length = 20)
    var nickname : String = nickname
        private set


}


