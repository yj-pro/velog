package com.yj.velog.common.advice;

import com.yj.velog.common.api.ErrorVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice(basePackages = "com.yj.velog")
public class CommonAdvice {
    // TODO exception handler

    @ExceptionHandler
    public ResponseEntity<ProblemDetail> illegalArgumentException(IllegalArgumentException e, HttpServletRequest request){
        List<ErrorVo> errors = new ArrayList<>();
        errors.add(new ErrorVo("", e.getMessage()));

        ProblemDetail pb = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()), "입력 값을 확인해주세요.");
        pb.setInstance(URI.create(request.getRequestURI()));
        pb.setType(URI.create(""));   // 나중에 docs 생기면 해당 docs로 연결
        pb.setTitle(HttpStatus.BAD_REQUEST.name());
        pb.setProperty("errors", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(pb);
    }
}
