package com.yj.velog.base.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class BaseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/v1/base (GET)")
    void getBase() throws Exception{
        //given
        String name = "최준호";

        //when
        ResultActions perform = mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/base")
                        .param("name", name)
                ).andDo(print());

        //then
        perform.andExpect(status().is2xxSuccessful());
        Assertions.assertThat(
                perform.andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8)
                ).contains(name);
    }
}