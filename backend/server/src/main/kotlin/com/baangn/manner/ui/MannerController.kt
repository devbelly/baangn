package com.baangn.manner.ui

import com.baangn.manner.application.MannerService
import com.baangn.manner.application.dto.CreateMannerRequest
import com.baangn.security.LoginUser
import com.baangn.user.domain.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/manner")
@RestController
class MannerController(
    private val mannerService: MannerService
) {
    @PostMapping
    fun evaluateManner(
        @LoginUser user: User,
        @RequestBody request: CreateMannerRequest
    ): ResponseEntity<Unit> {
        mannerService.create(user.id, request)
        return ResponseEntity.ok().build()
    }


}