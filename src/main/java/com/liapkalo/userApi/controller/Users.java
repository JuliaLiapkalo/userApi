package com.liapkalo.userApi.controller;

import com.liapkalo.userApi.entity.dto.BirthDto;
import com.liapkalo.userApi.entity.dto.UserDto;
import com.liapkalo.userApi.entity.dto.UserUpdateDto;
import com.liapkalo.userApi.service.SearchService;
import com.liapkalo.userApi.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Users {

    UserService userService;
    SearchService searchService;

    @PostMapping
    public ResponseEntity<?> addUser(@Validated @RequestBody UserDto user) {
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @Validated @RequestBody UserUpdateDto user) {
        return ResponseEntity.ok().body(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search-by-dates")
    public ResponseEntity<?> searchUsersByBirthDateRange(@Validated @RequestBody BirthDto birthDto) {
        return ResponseEntity.ok().body(searchService.searchByBirthDateRange(birthDto));
    }
}
