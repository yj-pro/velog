package com.yj.velog.board.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yj.velog.board.domain.dto.BoardDto;
import com.yj.velog.board.domain.entity.Board;
import com.yj.velog.board.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    @Test
    @DisplayName("/api/v1/board (GET)")
    void getBoard() throws Exception{
        //given
        Board save = boardRepository.save(Board.of("제목1", "내용1"));
        //when
        ResultActions perform = mockMvc.perform(
                get("/api/v1/board/{board_id}", save.getId())
        ).andDo(print());
        //then
        perform.andExpect(status().is2xxSuccessful());
    }



}