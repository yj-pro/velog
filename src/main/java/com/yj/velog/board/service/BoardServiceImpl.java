package com.yj.velog.board.service;

import com.yj.velog.board.domain.dto.PostBoardDto;
import com.yj.velog.board.domain.entity.Board;
import com.yj.velog.board.domain.vo.BoardVo;
import com.yj.velog.board.domain.vo.MessageVo;
import com.yj.velog.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public MessageVo postBoard(PostBoardDto postBoardDto) {
        boardRepository.save(Board.of(postBoardDto.getSubject(), postBoardDto.getContent()));
        return new MessageVo("게시글 등록 성공");
    }

    @Override
    public BoardVo getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("유효하지 않은 게시글입니다.")
        );
        return new BoardVo(board.getId(), board.getSubject(), board.getContent(), board.getCreatedAt(), board.getModifiedAt());
    }
}
