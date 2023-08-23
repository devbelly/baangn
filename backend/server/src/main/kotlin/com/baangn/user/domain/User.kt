package com.baangn.user.domain

import com.support.domain.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table


@Entity
@Table
class User(
    @Column(nullable = false)
    val oauthId: Long,

    nickname: String = "익명",

    location: Location? = null,

    profileUrl: String? = null,
    id: Long = 0L
) : BaseEntity(id) {

    @Column(length = 255)
    var location: Location? = location
        private set

    @Column(length = 20)
    var nickname: String = nickname
        private set

    @Column(length = 255)
    var profileUrl: String? = profileUrl
        private set

    @Column(nullable = false)
    var manner: Double = 36.5
        private set
    fun changeNickname(nickname: String) {
        require(nickname.length in 1..20) { "닉네임은 1자 이상 20자 이하로 입력해주세요." }
        this.nickname = nickname
    }

    fun changeLocation(location: Location) {
        require(location.address.length in 1..255) { "주소는 1자 이상 255자 이하로 입력해주세요." }
        this.location = location
    }

    fun changeProfileUrl(profileUrl: String) {
        require(profileUrl.length in 1..250) { "프로필 URL은 1자 이상 255자 이하로 입력해주세요." }
        this.profileUrl = profileUrl
    }

    fun updateManner(manner: Double){
        this.manner = manner
    }
}


