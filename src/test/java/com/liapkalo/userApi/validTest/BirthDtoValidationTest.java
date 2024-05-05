package com.liapkalo.userApi.validTest;

import com.liapkalo.userApi.entity.dto.BirthDto;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BirthDtoValidationTest {

    private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = validatorFactory.getValidator();

    @Test
    public void validateBirthDto_ValidDateRange_NoViolations() {
        LocalDate fromDate = LocalDate.of(2000, 1, 1);
        LocalDate toDate = LocalDate.of(2005, 12, 31);
        BirthDto birthDto = new BirthDto(fromDate, toDate);
        Set<ConstraintViolation<BirthDto>> violations = validator.validate(birthDto);

        assertTrue(violations.isEmpty());
    }

    @Test
    public void validateBirthDto_InvalidDateRange_ViolationDetected() {
        LocalDate fromDate = LocalDate.of(2006, 1, 1);
        LocalDate toDate = LocalDate.of(2005, 12, 31);
        BirthDto birthDto = new BirthDto(fromDate, toDate);

        Set<ConstraintViolation<BirthDto>> violations = validator.validate(birthDto);

        assertFalse(violations.isEmpty());
        assertEquals(1, violations.size());
        ConstraintViolation<BirthDto> violation = violations.iterator().next();
        assertEquals("Invalid date range. From should be less than To!", violation.getMessage());
    }
}

