package com.liapkalo.userApi.entity.dto;

import com.liapkalo.userApi.annotation.adultAge.AdultAge;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
@Builder
public class UserDto {

    @NotBlank
    @Email
    String email;

    @NotBlank
    @Size(min = 1, max = 255)
    String firstName;

    @NotBlank
    @Size(min = 1, max = 255)
    String lastName;

    @AdultAge
    @PastOrPresent
    LocalDate birthDate;

    String address;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number")
    String phoneNumber;
}
