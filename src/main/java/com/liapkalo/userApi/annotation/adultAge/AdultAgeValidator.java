package com.liapkalo.userApi.annotation.adultAge;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.Period;


public class AdultAgeValidator implements ConstraintValidator<AdultAge, LocalDate> {

    @Value("${allowed-age-to-register}")
    private Integer allowedAge;

    @Override
    public void initialize(AdultAge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if (localDate == null) {
            return true;
        }

        LocalDate today = LocalDate.now();
        Period period = Period.between(localDate, today);
        int age = period.getYears();
        return age >= allowedAge;
    }
}
