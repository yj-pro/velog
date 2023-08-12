package com.yj.velog.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.velog.board.domain.dto.BoardDto;
import com.yj.velog.board.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BoardRepository boardRepository;
    @Test
    @DisplayName("/api/v1/board (POST)")
    void postBoard() throws Exception{
        //given
        String subject = "제목";
        String content = "내용";
        BoardDto boardDto = new BoardDto(subject, content);
        //when
        ResultActions perform = mockMvc.perform(
                post("/api/v1/board").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(boardDto))
        );
        //then
        perform.andExpect(status().is2xxSuccessful());
    }

}