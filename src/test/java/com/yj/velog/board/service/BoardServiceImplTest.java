package com.yj.velog.board.service;

import com.yj.velog.board.domain.dto.BoardDto;
import com.yj.velog.board.domain.entity.Board;
import com.yj.velog.board.domain.vo.MessageVo;
import com.yj.velog.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BoardServiceImplTest {
    @InjectMocks
    private BoardServiceImpl boardService;

    @Mock
    private BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 등록 성공")
    void postBoardSuccess(){
        //given
        String subject = "제목";
        String content = "내용";
        BoardDto boardDto = new BoardDto(subject, content);
        given(boardRepository.save(any())).willReturn(Board.of(subject, content));

        //when
        MessageVo messageVo = boardService.postBoard(boardDto);
        //then
        Assertions.assertThat(messageVo.detail()).contains("성공");
    }
}