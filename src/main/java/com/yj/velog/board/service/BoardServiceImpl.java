package com.yj.velog.board.service;

import com.yj.velog.board.domain.dto.BoardDto;
import com.yj.velog.board.domain.entity.Board;
import com.yj.velog.board.domain.vo.MessageVo;
import com.yj.velog.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public MessageVo postBoard(BoardDto boardDto) {
        boardRepository.save(Board.of(boardDto.getSubject(), boardDto.getContent()));
        return new MessageVo("게시글 등록 성공");
    }
}
