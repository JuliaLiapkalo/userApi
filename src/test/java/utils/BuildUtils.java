package utils;

import com.liapkalo.userApi.entity.User;
import com.liapkalo.userApi.entity.dto.UserDto;
import com.liapkalo.userApi.entity.dto.UserUpdateDto;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class BuildUtils {

    public static User buildUser() {
        return User.builder()
                .id(1L)
                .firstName("Mike")
                .lastName("Joe")
                .email("mike@joe.com")
                .address("Kyiv")
                .birthDate(LocalDate.of(1997, 1, 19))
                .phoneNumber("+3(123)123-123-123")
                .build();
    }

    public static User buildInvalidUser() {
        return User.builder()
                .id(1L)
                .firstName("")
                .lastName("")
                .address("")
                .email("")
                .birthDate(null)
                .phoneNumber("")
                .build();
    }

    public static UserDto buildUserDto() {
        return UserDto.builder()
                .firstName("Mike")
                .lastName("Joe")
                .email("mike@joe.com")
                .address("Kyiv")
                .birthDate(LocalDate.of(1997, 1, 19))
                .phoneNumber("+3(123)123-123-123")
                .build();
    }

    public static UserUpdateDto buildFullUserUpdateDto() {
        return UserUpdateDto.builder()
                .firstName("New First Name")
                .lastName("New Last Name")
                .email("New Address")
                .birthDate(LocalDate.of(2000, 1, 29))
                .phoneNumber("+9(111)111-123")
                .address("Odessa").build();
    }

    public static UserUpdateDto buildUserUpdateDto() {
        return UserUpdateDto.builder()
                .firstName("New First Name")
                .address("Odessa").build();
    }
}
