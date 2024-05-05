package com.liapkalo.userApi.annotation.dateRang;

import com.liapkalo.userApi.entity.dto.BirthDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, BirthDto> {
    @Override
    public void initialize(ValidDateRange constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(BirthDto birthDto, ConstraintValidatorContext constraintValidatorContext) {
        if (birthDto == null) {
            return true;
        }
        return birthDto.getFrom() == null || birthDto.getTo() == null || birthDto.getFrom().isBefore(birthDto.getTo());
    }
}
