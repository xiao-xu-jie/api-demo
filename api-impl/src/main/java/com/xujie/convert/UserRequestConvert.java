package com.xujie.convert;

import com.xujie.VO.req.UserRequestDTO;
import com.xujie.domain.entity.UserRequestBO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestConvert {
    UserRequestBO dto2bo(UserRequestDTO dto);
}
