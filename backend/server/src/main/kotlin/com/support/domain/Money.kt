package com.support.domain

import java.math.BigDecimal
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Money private constructor(
    @Column var amount: BigDecimal,
    @Column var currency: String
) {

    companion object {
        private fun of(amount: BigDecimal, currency: String): Money {
            return Money(amount, currency)
        }

        fun krw(amount: BigDecimal): Money = of(amount, "KRW")
    }

    operator fun plus(other: Money) = of(amount + other.amount, currency)
}




