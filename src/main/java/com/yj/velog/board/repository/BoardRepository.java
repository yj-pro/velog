package com.yj.velog.board.repository;

import com.yj.velog.board.domain.entity.Board;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
