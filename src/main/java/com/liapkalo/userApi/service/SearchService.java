package com.liapkalo.userApi.service;

import com.liapkalo.userApi.entity.User;
import com.liapkalo.userApi.entity.dto.BirthDto;

import java.util.List;

public interface SearchService {

    List<User> searchByBirthDateRange(BirthDto birthDto);
}
