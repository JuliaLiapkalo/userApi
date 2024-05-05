package com.liapkalo.userApi.annotation.dateRang;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRange {
    String message() default "Invalid date range. From should be less than To!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
