package com.liapkalo.userApi.entity.dto;

import com.liapkalo.userApi.annotation.dateRang.ValidDateRange;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@ValidDateRange
public class BirthDto {

    @PastOrPresent
    LocalDate from;

    @PastOrPresent
    LocalDate to;
}
