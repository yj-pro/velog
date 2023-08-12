package com.yj.velog.board.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
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

    private Board(String subject, String content, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.subject = subject;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static Board of(String subject, String content){
        LocalDateTime now = LocalDateTime.now();
        return new Board(subject, content, now, now);
    }
}
