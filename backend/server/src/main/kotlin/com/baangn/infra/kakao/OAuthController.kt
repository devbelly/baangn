package com.baangn.infra.kakao

import org.hibernate.annotations.Generated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class OAuthController {

    @GetMapping("/oauth/kakao")
    fun redirectUrl(@RequestParam code: String): Unit {
        println(code)
    }
}