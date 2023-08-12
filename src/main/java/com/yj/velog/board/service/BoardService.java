package com.yj.velog.board.service;

import com.yj.velog.board.domain.dto.BoardDto;
import com.yj.velog.board.domain.vo.BoardVo;
import com.yj.velog.board.domain.vo.MessageVo;

public interface BoardService{
    MessageVo postBoard(BoardDto boardDto);
    BoardVo getBoard(Long id);
}
