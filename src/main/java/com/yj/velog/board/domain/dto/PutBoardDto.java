package com.yj.velog.board.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutBoardDto {
    @JsonProperty("board_id")
    @NotNull(message = "board_id 비어있을 수 없습니다.")
    private Long boardId;
    @NotNull(message = "subject 비어있을 수 없습니다.")
    @Length(min = 1, max = 50)
    private String subject;
    @NotNull(message = "content 비어있을 수 없습니다.")
    @Length(min = 1, max = 1000, message = "최대 1000자까지 입력 가능합니다.")
    private String content;
}
