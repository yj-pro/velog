package com.yj.velog.board.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    @NotNull(message = "subject 비어있을 수 없습니다.")
    @Length(min = 1, max = 50)
    private String subject;
    @NotNull(message = "content 비어있을 수 없습니다.")
    @Length(min = 1, max = 1000, message = "최대 1000자까지 입력 가능합니다.")
    private String content;
}
