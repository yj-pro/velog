package com.yj.velog.board.service;

import com.yj.velog.board.domain.dto.PutBoardDto;
import com.yj.velog.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.catchThrowable;

@ExtendWith(MockitoExtension.class)
class BoardServiceImplTest {
    @InjectMocks
    private BoardServiceImpl boardService;

    @Mock
    private BoardRepository boardRepository;

    @Test
    @DisplayName("게시글 불러오기 실패")
    void getBoardFail1(){
        //given
        //when
        Throwable throwable = catchThrowable(() -> boardService.getBoard(0L));
        //then
        Assertions.assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 게시글");
    }

    @Test
    @DisplayName("게시글 수정 실패")
    void putBoardFail1(){
        //given
        PutBoardDto putBoardDto = new PutBoardDto(0L, "제목", "내용");
        //when
        Throwable throwable = catchThrowable(() -> boardService.putBoard(putBoardDto));
        //then
        Assertions.assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 게시글");
    }
}