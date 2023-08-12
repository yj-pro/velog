package com.yj.velog.board.controller;

import com.yj.velog.board.domain.dto.BoardDto;
import com.yj.velog.board.domain.vo.BoardVo;
import com.yj.velog.board.domain.vo.MessageVo;
import com.yj.velog.board.service.BoardService;
import com.yj.velog.common.api.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<Api<MessageVo>> postBoard(@RequestBody @Validated BoardDto boardDto, BindingResult bindingResult){
        // 나중에 aop로 빼야됨
        if(bindingResult.hasErrors()){
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new Api<>("0001", "success", boardService.postBoard(boardDto)));
    }

    @GetMapping("/board/{board_id}")
    public ResponseEntity<Api<BoardVo>> getBoard(@PathVariable(name = "board_id") Long boardId){
        return ResponseEntity.ok(new Api<>("0000", "success", boardService.getBoard(boardId)));
    }
}
