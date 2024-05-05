package com.liapkalo.userApi.repository;

import com.liapkalo.userApi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByBirthDateAfterAndBirthDateBefore(LocalDate from, LocalDate to);
}
