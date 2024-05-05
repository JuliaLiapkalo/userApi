package com.liapkalo.userApi.service.impl;

import com.liapkalo.userApi.entity.User;
import com.liapkalo.userApi.entity.dto.BirthDto;
import com.liapkalo.userApi.repository.UserRepository;
import com.liapkalo.userApi.service.SearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SearchServiceImpl implements SearchService {

    UserRepository userRepository;

    @Override
    public List<User> searchByBirthDateRange(BirthDto birthDto) {
        log.info("Staring search by birth date range : from {}, to {}", birthDto.getFrom(), birthDto.getTo());

        return userRepository.findAllByBirthDateAfterAndBirthDateBefore(birthDto.getFrom(), birthDto.getTo());
    }
}
