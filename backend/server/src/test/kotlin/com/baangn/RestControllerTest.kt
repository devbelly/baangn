package com.baangn

import com.baangn.security.LoginUserResolver
import com.ninjasquad.springmockk.MockkBean
import com.support.test.TestEnvironment
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs

@TestEnvironment
abstract class RestControllerTest {
    @MockkBean
    private lateinit var loginUserResolver: LoginUserResolver

    @Autowired
}