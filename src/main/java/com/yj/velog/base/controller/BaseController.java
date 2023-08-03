package com.yj.velog.base.controller;

import com.yj.velog.base.domain.vo.BaseVo;
import com.yj.velog.base.service.BaseService;
import com.yj.velog.common.api.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/base")
@RequiredArgsConstructor
public class BaseController {
    private final BaseService baseService;

    @GetMapping
    public ResponseEntity<Api<BaseVo>> base(@RequestParam String name){
        return ResponseEntity.ok(
                new Api<>(
                        "0000",
                        "success",
                        baseService.getBase(name)
                )
        );
    }
}
