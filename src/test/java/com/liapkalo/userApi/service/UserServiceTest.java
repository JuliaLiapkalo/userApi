package com.liapkalo.userApi.service;

import com.liapkalo.userApi.entity.User;
import com.liapkalo.userApi.entity.dto.UserDto;
import com.liapkalo.userApi.entity.dto.UserUpdateDto;
import com.liapkalo.userApi.entity.mapper.UserMapper;
import com.liapkalo.userApi.repository.UserRepository;
import com.liapkalo.userApi.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static utils.BuildUtils.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testCreateUser() {
        UserDto userDto = buildUserDto();

        User user = new User();
        when(userMapper.toUser(userDto)).thenReturn(user);
        User savedUser = buildUser();
        when(userRepository.save(user)).thenReturn(savedUser);

        User createdUser = userService.createUser(userDto);

        verify(userMapper, times(1)).toUser(userDto);
        verify(userRepository, times(1)).save(user);
        assertEquals(savedUser, createdUser);
    }

    @Test
    public void testUpdateUser() {

        UserUpdateDto userUpdateDto = buildFullUserUpdateDto();

        User existingUser = buildUser();

        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        User user = userService.updateUser(1L, userUpdateDto);

        verify(userRepository, times(1)).findById(1L);

        assertEquals("New First Name", user.getFirstName());
        assertEquals("New Last Name", user.getLastName());
        assertEquals("Odessa", user.getAddress());
        assertEquals("+9(111)111-123", user.getPhoneNumber());

        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void deleteUser_existingUser() {
        Long userId = 1L;
        User existingUser = buildUser();
        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));

        userService.deleteUser(userId);

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).delete(existingUser);
    }

    @Test
    public void deleteUser_nonExistingUser() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        userService.deleteUser(userId);

        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, never()).delete(any());
    }
}
