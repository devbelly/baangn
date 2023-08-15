package com.baangn.user.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Location(
    @Column val address: String
) {
    init {
        require(address.isNotBlank())
    }
}