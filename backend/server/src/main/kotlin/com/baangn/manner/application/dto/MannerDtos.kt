package com.baangn.manner.application.dto

import com.baangn.manner.domain.ComplimentType
import com.baangn.manner.domain.MannerCompliment

data class CreateMannerRequest(
    val evaluatorId: Long,
    val productId: Long,
    val mannerCompliment : MannerCompliment
)