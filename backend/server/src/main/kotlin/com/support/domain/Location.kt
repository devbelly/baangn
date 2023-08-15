package com.support.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Location(
    location: String = ""
) {
    @Column(nullable = false)
    var location = location
        private set
}
