package com.liapkalo.userApi.service.impl;


import com.liapkalo.userApi.entity.User;
import com.liapkalo.userApi.entity.dto.UserDto;
import com.liapkalo.userApi.entity.dto.UserUpdateDto;
import com.liapkalo.userApi.entity.mapper.UserMapper;
import com.liapkalo.userApi.repository.UserRepository;
import com.liapkalo.userApi.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;


    @Override
    public User createUser(UserDto user) {
        log.info("Creating user: {}", user);
        return userRepository.save(userMapper.toUser(user));
    }

    @Override
    public User updateUser(Long id, UserUpdateDto userDto) {
        log.info("Updating user: {}", userDto);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Film with id " + id + " not found"));

        updateUserFields(user, userDto);

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user: {}", id);
        userRepository.findById(id).ifPresent(userRepository::delete);;
    }

    private void updateUserFields(User user, UserUpdateDto userDto) {
        log.info("Updating user fields: {}", userDto);
        Map<String, Method> setters = getSetterMethods(User.class);
        Field[] fields = userDto.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(userDto);
                if (value != null) {
                    String fieldName = field.getName();
                    Method setter = setters.get(fieldName.toLowerCase());
                    if (setter != null) {
                        setter.invoke(user, value);
                    }
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }

    private Map<String, Method> getSetterMethods(Class<?> clazz) {
        Map<String, Method> setters = new HashMap<>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set") && method.getParameterCount() == 1) {
                String fieldName = method.getName().substring(3);
                setters.put(fieldName.toLowerCase(), method);
            }
        }
        return setters;
    }

}
