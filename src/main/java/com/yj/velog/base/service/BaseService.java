package com.yj.velog.base.service;


import com.yj.velog.base.domain.vo.BaseVo;

public sealed interface BaseService permits BaseServiceImpl{
    BaseVo getBase(String name);

}
