package com.liapkalo.userApi.service;

import com.liapkalo.userApi.entity.User;
import com.liapkalo.userApi.entity.dto.UserDto;
import com.liapkalo.userApi.entity.dto.UserUpdateDto;

public interface UserService {

    User createUser(UserDto user);
    User updateUser(Long id, UserUpdateDto user);
    void deleteUser(Long id);
}
