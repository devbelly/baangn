package com.baangn.user.ui

import com.baangn.user.application.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/users")
@RestController
class UserController(
    private val userService: UserService,

) {
    @PostMapping("/register")
    fun register()
}