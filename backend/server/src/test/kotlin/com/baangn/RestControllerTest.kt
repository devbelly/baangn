package com.baangn

import com.baangn.security.LoginFailedException
import com.baangn.security.LoginUser
import com.baangn.security.LoginUserResolver
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import com.support.test.TestEnvironment
import com.support.ui.ApiResponse
import io.mockk.every
import io.mockk.slot
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.MethodParameter
import org.springframework.http.HttpHeaders.AUTHORIZATION
import org.springframework.http.MediaType.*
import org.springframework.test.web.servlet.MockHttpServletRequestDsl
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.result.ContentResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.filter.CharacterEncodingFilter

@TestEnvironment
abstract class RestControllerTest {
    @MockkBean
    private lateinit var loginUserResolver: LoginUserResolver

    @Autowired
    lateinit var objectMapper: ObjectMapper

    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp(
        webApplicationContext: WebApplicationContext
    ) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .addFilter<DefaultMockMvcBuilder>(CharacterEncodingFilter("UTF-8", true))
            .alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print())
            .build()

        loginUserResolver.also {
            slot<MethodParameter>().also { slot ->
                every { it.supportsParameter(capture(slot)) } answers {
                    slot.captured.hasMethodAnnotation(LoginUser::class.java)
                }
            }
            slot<NativeWebRequest>().also { slot ->
                every { it.resolveArgument(any(), any(), capture(slot), any()) } answers {
                    val hasToken = slot.captured.getHeader(AUTHORIZATION)?.startsWith("Bearer")
                    if (hasToken != true) {
                        throw LoginFailedException()
                    }
                    createUser()
                }
            }
        }
    }

    fun MockHttpServletRequestDsl.jsonContent(value: Any){
        content = objectMapper.writeValueAsString(value)
        contentType = APPLICATION_JSON
    }

    fun ContentResultMatchers.success(value: Any): ResultMatcher{
        return json(objectMapper.writeValueAsString(ApiResponse.success(value)))
    }
}