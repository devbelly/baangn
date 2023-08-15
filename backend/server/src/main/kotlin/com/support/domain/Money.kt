package com.support.domain

import com.baangn.common.utils.greaterThanEqual
import com.baangn.common.utils.lessThanEqual
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
            require(amount.greaterThanEqual(BigDecimal.ZERO)) { "상품가격은 0원 이상이여야 합니다." }
            require(amount.lessThanEqual(BigDecimal.valueOf(999_999_999))) { "상품가격은 999,999,999원 이하여야 합니다" }
            return Money(amount, currency)
        }

        fun krw(amount: BigDecimal): Money = of(amount, "KRW")
    }

    operator fun plus(other: Money) = of(amount + other.amount, currency)
}




