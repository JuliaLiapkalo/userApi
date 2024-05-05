package com.liapkalo.userApi.entity.dto;

import com.liapkalo.userApi.annotation.adultAge.AdultAge;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserUpdateDto {

    @Email
    String email;

    @Size(min = 1, max = 255)
    String firstName;

    @Size(min = 1, max = 255)
    String lastName;

    @AdultAge
    @PastOrPresent
    LocalDate birthDate;

    String address;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number")
    String phoneNumber;
}
