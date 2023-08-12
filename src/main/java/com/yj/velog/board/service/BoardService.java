package com.yj.velog.board.service;

import com.yj.velog.board.domain.dto.BoardDto;
import com.yj.velog.board.domain.vo.MessageVo;

public sealed interface BoardService permits BoardServiceImpl{
    MessageVo postBoard(BoardDto boardDto);

}
