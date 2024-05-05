package com.liapkalo.userApi.service;

import com.liapkalo.userApi.entity.User;
import com.liapkalo.userApi.entity.dto.BirthDto;
import com.liapkalo.userApi.repository.UserRepository;
import com.liapkalo.userApi.service.impl.SearchServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static utils.BuildUtils.buildUser;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private SearchServiceImpl searchService;

    @Test
    public void searchByBirthDateRange_WithinRange_ReturnsUsers() {

        LocalDate fromDate = LocalDate.of(2000, 1, 1);
        LocalDate toDate = LocalDate.of(2005, 12, 31);
        BirthDto birthDto = new BirthDto(fromDate, toDate);

        when(userRepository.findAllByBirthDateAfterAndBirthDateBefore(fromDate, toDate))
                .thenReturn(Collections.singletonList(buildUser()));

        List<User> users = searchService.searchByBirthDateRange(birthDto);

        assertEquals(1, users.size());
    }

    @Test
    public void searchByBirthDateRange_NoUsersFound_ReturnsEmptyList() {
        BirthDto birthDto = new BirthDto(null, null);

        when(userRepository.findAllByBirthDateAfterAndBirthDateBefore(birthDto.getFrom(), birthDto.getTo()))
                .thenReturn(Collections.emptyList());

        List<User> users = searchService.searchByBirthDateRange(birthDto);

        assertEquals(0, users.size());
    }

}
