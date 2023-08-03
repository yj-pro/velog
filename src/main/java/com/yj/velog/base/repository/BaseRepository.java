package com.yj.velog.base.repository;

import com.yj.velog.base.domain.entity.Base;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BaseRepository {
    // temp db 추후에는 Entity와 jpa Repository로 대체
    public Optional<Base> findByName(String name){
        // temp DB
        Map<String, Base> map = new HashMap<>();
        map.put("최준호", new Base(1L, "최준호", 30));
        map.put("이윤민", new Base(1L, "이윤민", 29));

        return Optional.ofNullable(map.get(name));
    }
}
