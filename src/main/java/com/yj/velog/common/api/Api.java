package com.yj.velog.common.api;

public record Api<T>(
        /**
         * TODO 성공 코드와 에러 코드는 서로 협의 하에 진행하기
         */
        String code,
        String message,
        T data
){}
