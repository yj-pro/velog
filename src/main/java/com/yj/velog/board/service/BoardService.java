package com.yj.velog.board.service;

import com.yj.velog.board.domain.dto.PatchBoardDto;
import com.yj.velog.board.domain.dto.PostBoardDto;
import com.yj.velog.board.domain.vo.BoardVo;
import com.yj.velog.board.domain.vo.MessageVo;

public interface BoardService{
    MessageVo postBoard(PostBoardDto postBoardDto);
    BoardVo getBoard(Long id);

    BoardVo patchBoard(PatchBoardDto patchBoardDto);
}
