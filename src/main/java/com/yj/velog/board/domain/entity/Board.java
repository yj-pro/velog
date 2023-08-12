package com.yj.velog.board.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String subject;
    @Column(nullable = false, length = 1000)
    private String content;

    // Member 생기면 Member 추가

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
