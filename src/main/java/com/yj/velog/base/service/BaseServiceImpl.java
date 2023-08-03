package com.yj.velog.base.service;

import com.yj.velog.base.domain.entity.Base;
import com.yj.velog.base.domain.vo.BaseVo;
import com.yj.velog.base.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class BaseServiceImpl implements BaseService {
    private final BaseRepository baseRepository;
    @Override
    public BaseVo getBase(String name) {
        Base base = baseRepository.findByName(name).orElseThrow(() ->
                new IllegalArgumentException("유효하지 않은 회원입니다.")
        );

        return new BaseVo(base.getName(), base.getAge());
    }
}
