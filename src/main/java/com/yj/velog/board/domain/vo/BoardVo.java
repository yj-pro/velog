package com.yj.velog.board.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardVo {
    private Long id;
    private String subject;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
