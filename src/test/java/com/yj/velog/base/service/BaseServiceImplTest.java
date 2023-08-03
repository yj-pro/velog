package com.yj.velog.base.service;

import com.yj.velog.base.repository.BaseRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BaseServiceImplTest {
    @InjectMocks
    private BaseServiceImpl baseService;

    @Mock
    private BaseRepository baseRepository;

    @Test
    @DisplayName("존재 하지 않는 회원의 name 검색은 fail")
    void getBaseFail1(){
        //given
        String name = "최준";
        given(baseRepository.findByName(anyString())).willReturn(Optional.ofNullable(null));
        //when
        Throwable throwable = catchThrowable(() -> baseService.getBase(name));
        //then
        Assertions.assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 회원");
    }
}