package com.support.utils

import java.math.BigDecimal

fun BigDecimal.isZero(): Boolean = this.compareTo(BigDecimal.ZERO) == 0

fun BigDecimal?.multiplyNullable(decimal: BigDecimal?): BigDecimal? =
    if (this != null && decimal != null) this.multiply(decimal) else null

fun BigDecimal.equalTo(a: BigDecimal) = this.compareTo(a) == 0

fun BigDecimal.greaterThan(a: BigDecimal) = this.compareTo(a) == 1

fun BigDecimal.greaterThanEqual(a: BigDecimal) = this.compareTo(a) >= 1

fun BigDecimal.lessThanEqual(a : BigDecimal) = this.compareTo(a) <= 1

fun BigDecimal?.orZero(): BigDecimal = this ?: BigDecimal.ZERO

fun BigDecimal.nullZero(): BigDecimal? = if (this.isZero()) null else this