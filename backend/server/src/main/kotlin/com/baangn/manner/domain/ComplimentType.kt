package com.baangn.manner.domain

enum class ComplimentType(val point: Double) {
    NOT_GOOD(-0.5),
    GOOD(-0.5),
    BEST(1.0),
    NONE(0.0)
}