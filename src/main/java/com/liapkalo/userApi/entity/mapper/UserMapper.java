package com.liapkalo.userApi.entity.mapper;

import com.liapkalo.userApi.entity.User;
import com.liapkalo.userApi.entity.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDto userDto);

}
