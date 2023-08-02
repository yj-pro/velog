package com.yj.velog.common.api;

public record ErrorVo(
        String point,   // error가 난 포인트 ex) null exception일 경우 null이 난 부분
        String detail   // error가 난 자세한 이유
) {}
