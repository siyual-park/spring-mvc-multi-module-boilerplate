package io.github.siyual_park.controller

import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@ControllerTest
class PingControllerTest(
    private val mockMvc: MockMvc,
) {

    @Test
    fun testPing() {
        mockMvc.get("/ping")
            .andExpect {
                status { isOk() }
                content { string("pong") }
            }
    }
}
